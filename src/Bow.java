public class Bow implements Weapon{
    String name ;
    private int level = 0;
    private final double Base_atk;
    private double atk = 0;
    private final double Base_Reduce_speed;
    private double reduce_speed;
    /** Constructor of create sword class
     *  @param name to set name of this object.
     *  effects: Set any stat of this sword.
     */
    Bow(String name){
        this.name = name;
        this.Base_atk = 30;
        this.Base_Reduce_speed = 1;
        this.atk = Base_atk;
        this.reduce_speed = Base_Reduce_speed;
    };
    /** Enhance weapon and increase stat of this sword
     *  effect: Increase level and stat of this sword.
     */
    @Override
    public void enhance() {
        level = level+1;
        if(level < 5){
            this.atk = Base_atk + (double)(0.5)*level;
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        unique_Skill(level);
        if(level > 5 && level < 10){
            this.atk = (double)3*(Base_atk + (double)(0.5)*level);
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        if(level >= 10){
            atk = (double)(4)*(Base_atk+(double)(0.5)*level);
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        getCurrentInfo();
    }
    /** Unique skill for this sword.
     *  @param level unique skill is depended on sword level.
     *  effects: Display text when sword level can be unlocked the unique skill.
     *  effects: Increase any stat of this sword.
     */
    private void unique_Skill(int level) {
        if(level == 5){
            System.out.println("You unlock unique skill poison arrow.");
            atk = (double)3*(Base_atk + (double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
        if(level == 10){
            System.out.println("You unlock unique skill fire arrow.");
            atk = (double)(4)*(Base_atk+(double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
    }
    /** Give hero about atk stat of this sword.
     *  @return atk value of this sword.
     */
    @Override
    public double getAtk() {
        double deep_atk = atk;
        return deep_atk;
    }
    /** Give hero about reduce speed state of this sword.
     *  @return reduceSpeed value.
     */
    @Override
    public double getReduceSpeed(){
        double deep_redeceSpeed = reduce_speed;
        return deep_redeceSpeed;
    }
    /** Get current information about this sword
     *  effects: Display text about current stat information about this sword.
     */
    protected void getCurrentInfo(){
        System.out.println("Atk:"+this.getAtk() + " Reduce speed:"+this.getReduceSpeed());
    }
}
