package  com.cleo.LowLevelDesign.DesignATM.ATMStates;

import  com.cleo.LowLevelDesign.DesignATM.ATM;
import  com.cleo.LowLevelDesign.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
