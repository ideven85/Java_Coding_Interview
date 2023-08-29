package com.cleo.LowLevelDesign.LLdCricbuzz.Team;

import com.cleo.LowLevelDesign.LLdCricbuzz.Inning.BallDetails;
import com.cleo.LowLevelDesign.LLdCricbuzz.Inning.OverDetails;
import com.cleo.LowLevelDesign.LLdCricbuzz.Team.Player.PlayerDetails;

public class Wicket {

    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetail;
    public BallDetails ballDetail;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}
