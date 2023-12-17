package com.cleo.LowLevelDesign.DesignSplitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {

    void validateSplitRequest(List<Split> splitList, double totalAmount);
}
