package code.GameEnity.Enemy;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import static code.Config.*;
public abstract class NormalEnemy extends Rectangle implements Enemy {
    private int armor;
    private int speedRunning;
    private int blood;
    private int bonusCoins;
    private int upward = 0 , downward = 1, right = 2, left = 3;
    private int  direction = right;
    private boolean hasUpWard = false;
    private boolean hasDownWard = false;
    private boolean hasRight = false;
    private boolean hasLeft = false;
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeedRunning() {
        return speedRunning;
    }

    public void setSpeedRunning(int speedRunning) {
        this.speedRunning = speedRunning;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getBonusCoins() {
        return bonusCoins;
    }

    public void setBonusCoins(int bonusCoins) {
        this.bonusCoins = bonusCoins;
    }

    public NormalEnemy(int x , int y, int width, int height, int armor, int speedRunning, int blood, int bonusCoins){
        this.armor = armor;
        this.blood = blood;
        this.bonusCoins = bonusCoins;
        this.speedRunning = speedRunning;
        for(int i = 0; i < field_width; i++){
            if(map[i][0]==1){
                x = i;
                y = field_height;
                setBounds(x, y, width, height);
            }
        }
    }
//    public boolean passable(int[][] map, int field_height, int field_width, int x, int y){
//        return (x >= 0 && x < field_width && y >= 0 && y < field_height && map[y][x] == 1;
//    }
    public boolean move(){
        if(direction == right){
            x+=1;
            hasRight = true;
        }
        else if(direction == left){
            x-=1;
            hasLeft = true;
        }
        else if(direction == upward){
            y-=1;
            hasUpWard = true;
        }
        else if(direction == downward){
            y+=1;
            hasDownWard = true;
        }
        if(!hasDownWard){
            try{
                if(map[y-1][x] == 1){
                    direction = upward;
                }
            } catch (Exception e)
        }
        if(!hasUpWard){
            try{
                if(map[y+1][x] == 1) {
                    direction = downward;
                }
            }catch (Exception e);
        }
        if(!hasRight){
            try{
                if(map[y][x-1] == 1){
                    direction = left;
                }
            }catch (Exception e);
        }
        if(!hasLeft){
            try{
                if(map[y][x+1] == 1){
                    direction = right;
                }
            }catch (Exception e);
        }
    }
    public void beAttackedByNormalTower(){

    }

    public void beAttackedBySniperTower(){

    }

    public void beAttackedbyGunTower(){

    }
    public void draw (Graphics g){g.drawImage(img_Enemy[0],x,y,width,height,null);}
}
