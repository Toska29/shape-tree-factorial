package main.questionFive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeradataTransfer {
    public static void main(String[] args) throws IOException {
        TeradataNetwork network = new TeradataNetwork();

        try (BufferedReader reader = new BufferedReader(new FileReader("teradata-world-setup.txt"))) {
            int totalBanks = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= totalBanks; i++) {
                network.banks.put(i, new Bank(i));
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                int parentBankId = Integer.parseInt(tokens[0]);
                int childBankId = Integer.parseInt(tokens[1]);
                network.addConnection(parentBankId, childBankId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<String> clientRequests = new ArrayList<>();
        clientRequests.add("4,2,2");
        clientRequests.add("5,1,2");
        clientRequests.add("2,4,1");
        clientRequests.add("9,10,5");
        clientRequests.add("7,10,100");
        clientRequests.add("1,5,8");
        clientRequests.add("9,10,2");
        clientRequests.add("7,10,3");

        for (String request : clientRequests) {
            if (request.equals("END")) {
                System.out.println("END");
                break;
            }

            String[] tokens = request.split(",");
            int sourceBankId = Integer.parseInt(tokens[0]);
            int destinationBankId = Integer.parseInt(tokens[1]);
            int threshold = Integer.parseInt(tokens[2]);

            Bank sourceBank = network.banks.get(sourceBankId);
            Bank destinationBank = network.banks.get(destinationBankId);

            boolean canTransfer = network.canTransferFunds(sourceBank, destinationBank, threshold);
            System.out.println(canTransfer ? "YES" : "NO");
        }
    }
}
