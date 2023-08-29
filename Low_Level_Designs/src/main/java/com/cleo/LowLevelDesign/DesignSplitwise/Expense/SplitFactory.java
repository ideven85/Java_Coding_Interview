package com.cleo.LowLevelDesign.DesignSplitwise.Expense;

import com.cleo.LowLevelDesign.DesignSplitwise.Expense.Split.EqualExpenseSplit;
import com.cleo.LowLevelDesign.DesignSplitwise.Expense.Split.ExpenseSplit;
import com.cleo.LowLevelDesign.DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import com.cleo.LowLevelDesign.DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
