package com.cleo.oct29;

public class HardGame {
    public int powerup(int N, int K, int[] energyArr){
        // Code Here
        int remaining_energy=K;
        for (int i = N-1; i >=0 ; i--) {
            remaining_energy=remaining_energy-energyArr[i];
            if(energyArr[i]==0)
                remaining_energy+=K;
            if(remaining_energy>=0)
                return i;


        }
        return -1;
    }

    public static void main(String[] args) {
        int N=10,K=5;
        int[] arr={4,0,1,1,1,1,0,3,2,6};
        HardGame game = new HardGame();
        System.out.println(game.powerup(N,K,arr));
    }
}
