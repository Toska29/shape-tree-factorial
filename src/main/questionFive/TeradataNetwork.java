package main.questionFive;

import java.util.HashMap;
import java.util.Map;

public class TeradataNetwork {
    Map<Integer, Bank> banks;

    public TeradataNetwork() {
        this.banks = new HashMap<>();
    }

    public void addConnection(int parentBankId, int childBankId) {
        Bank parentBank = banks.get(parentBankId);
        Bank childBank = banks.get(childBankId);

        childBank.parent = parentBank;
        parentBank.children.add(childBank);
    }

    public boolean canTransferFunds(Bank sourceBank, Bank destinationBank, int threshold) {
        int pathLength = getPathLength(sourceBank, destinationBank);
        return pathLength <= threshold;
    }

    public int getPathLength(Bank sourceBank, Bank destinationBank) {
        int length = 0;
        Bank currentBank = sourceBank;

        while (currentBank != destinationBank && currentBank != null) {
            currentBank = currentBank.parent;
            length++;
        }

        return currentBank == destinationBank ? length : Integer.MAX_VALUE;
    }
}
