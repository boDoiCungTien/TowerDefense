package code.GameEnity.Enemy;

import code.GameEnity.GameEnity;

public interface Enemy extends GameEnity {
    public boolean contains(int x, int y);
    public void subtractBlood_(int blood);
    public int getBlood_();
    public int getREWARD_();
}
