package com.cleo.LowLevelDesign.LLdCricbuzz.ScoreUpdater;


import com.cleo.LowLevelDesign.LLdCricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
