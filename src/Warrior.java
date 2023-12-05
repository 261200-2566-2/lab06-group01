public class Warrior implements Hero{
    private double Max_HP;
    protected double HP;
    private double Max_Mana;
    private double Mana;
    private double Max_Speed;
    protected double speed;
    private double Base_ATK;
    private double Buff_ATK;
    private double atk;
    private double Base_DEF;
    protected double def;
    private int level = 0;
    private int turn = 0;
    private boolean equipSword = false;
    private boolean equipBow = false;
    private Sword s1;
    private Bow b1;
    String name;

    /** Constructor for create object in warrior class
     *  @param name to set name of this object.
     *  effects: Set any stat to this hero.
     *  effects: Display text about base stat of this hero
     */
    Warrior(String name){
        this.name = name;
        this.HP = Hero.HP;
        this.Mana = Hero.Mana;
        this.atk = Hero.atk;
        this.def = Hero.def;
        this.speed = Hero.speed;
        this.Max_Speed = Hero.speed;
        this.Max_HP = Hero.HP;
        this.Max_Mana = Hero.Mana;
        this.Base_ATK = Hero.atk;
        this.Base_DEF = Hero.def;
        System.out.println("Create Warrior Name: " + this.name + " Level: " + this.level + " Maximum HP: "+this.Max_HP+ " Maximum Mana: "+this.Max_Mana+" Max Speed: "+this.Max_Speed+ " Base ATK: "+this.Base_ATK+" Base DEF: "+this.Base_DEF);
    }

    /** Attack to warrior in field.
     * effects: Display a text who is attacker and who is defender
     * effect: Display a text how much damage this warrior can do at enemy.
     * @param  w is warrior in the field who is attacked by this hero.
     * @return Damage that is hero receives.
     * */
    @Override
    public double attack(Warrior w) {
        System.out.println("Warrior " + this.name + " Attack Warrior " + w.name);
        if (atk - w.def > 0) {
            if(atk-w.def >= w.HP){
                w.HP = 0;
            }else{
                w.HP = w.HP - (atk - w.def);
            }
            System.out.println("Warrior " + this.name + " Attack Warrior " + w.name + " Attack: " + (this.atk - w.def) + " Warrior HP: " + w.HP);
            return atk - w.def;
        } else {
            return 0;
        }
    }
    /** Attack to archer in field.
     * effects: Display a text who is attacker and who is defender
     * effects: Display a text how much damage this warrior can do at enemy.
     * @param  a is archer in the field who is attacked by this hero.
     * @return Damage that is hero receives.
     * */
    @Override
    public double attack(Archer a){
        if(atk - a.def > 0){
            if(atk-a.def >= a.HP){
                a.HP = 0;
            }else{
                a.HP = a.HP - (atk - a.def);
            }
            System.out.println("Warrior "+this.name + " Attack Archer "+a.name+ " Attack: "+(this.Buff_ATK-a.def)+" Archer HP: "+a.HP);
            return atk - a.def;
        }else{
            return 0;
        }
    }

    /** If this hero didn't equip bow,it will equip sword.
     * effects: Increase any stat of hero with that sword.
     * effects: Display the text to tell user why doesn't equip sword.
     */
    @Override
    public void equip_Weapon_Sword() {
        if(!equipBow){
            s1 = new Sword("Fire Sword");
            atk = Base_ATK + (2.5*level) + s1.getAtk();
            speed = speed - s1.getReduceSpeed();
            equipSword = true;
            getCurrentInfo();
        }else{
            System.out.println("You should unequip bow before equip another weapon by unequipBow() method");
        }
    }
    /** If this hero didn't equip sword,it will equip bow.
     * effects: Increase any stat of hero with that bow.
     * effects: Display the text to tell user why doesn't equip bow.
     */
    @Override
    public void equip_Weapon_Bow() {
        if(!equipSword){
            b1 = new Bow("Cross Bow");
            atk = Base_ATK + (2.5*level) + (double)(1/2)*b1.getAtk();
            speed = speed - b1.getReduceSpeed();
            equipBow = true;
            getCurrentInfo();
        }else{
            System.out.println("You should unequip sword before equip another weapon by unequipSword() method");
        }
    }
    /** Level up this hero.
     * effects: Increase any stat of hero
     * effects: Display text when level hero can unlock unique skill.
     * */
    @Override
    public void Level_UP() {
        level = level+1;
        Max_HP = Max_HP + (10*level);
        Max_Mana = Max_Mana + (2*level);
        Max_Speed = Max_Speed + (3.5*level);
        HP = Max_HP;
        Mana = Max_Mana;
        speed = Max_Speed;
        atk = Base_ATK + (10*level);
        def = Base_DEF + (5*level);
        getCurrentInfo();
        if(level == 5){
            System.out.println("Unlock 1st unique skill Crazy Sword");
        }
    }

    /** Display max stat information of hero on that level.
     *  effects: Display text about max stat on that level.
     */
    @Override
    public void getMaxInfo() {
        System.out.println("Name: "+this.name + " Level: " + this.level + " Maximum HP: "+this.Max_HP+ " Maximum Mana: "+this.Max_Mana+" Max Speed: "+this.Max_Speed+ " Base ATK: "+this.Base_ATK+" Base DEF: "+this.Base_DEF);
    }

    /** Display current stat information of hero on that level.
     *  effects: Display text about current stat on that level.
     */
    @Override
    public void getCurrentInfo(){
        System.out.println("Name: "+this.name + " Level: " + this.level + " Current HP: "+this.HP+ " Current Mana: "+this.Mana+" Current Speed: "+this.speed+ " Current ATK: "+this.atk+" Current DEF: "+this.def);
    }
    /** Unique skill to attack the warrior.
     * @param w is warrior who is attacked by this hero with unique skill.
     *  effects: Display text about this attack.
     */
    public double Crazy_Warrior(Warrior w){
        if(w.HP <= 0){
            System.out.println("This round was ended pls restart again.");
            return 0;
        }
        if(level >= 5){
            Mana = Mana-(double)(1/4)*Mana;
            if(w.HP < atk*1.5){
                w.HP = 0;
            }else{
                w.HP = w.HP - atk*1.5;
            }
            System.out.println("Warrior "+this.name + " Attack warrior "+w.name + " by unique skill Crazy Sword ATK:"+atk*1.5+" Warrior HP: "+w.HP);
            gameEnd(w);
            return atk*1.5;
        }else{
            System.out.println("You can't use this skill this skill will unlock when you level 5");
            return 0;
        }
    }
    /** Unique skill to attack the archer.
     * @param a is archer who is attacked by this hero with unique skill.
     *  effects: Display text about this attack.
     */
    public double Crazy_Warrior(Archer a){
        if(a.HP <= 0){
            System.out.println("This round was ended pls restart again.");
            return 0;
        }
        if(level >= 5){
            Mana = Mana-(double)(1/4)*Mana;
            if(a.HP < atk*1.5){
                a.HP = 0;
            }else{
                a.HP = a.HP - atk*1.5;
            }
            System.out.println("Warrior "+this.name + " Attack archer "+a.name + " by unique skill Crazy Sword ATK:"+atk*1.5+" Archer HP: "+a.HP);
            gameEnd(a);
            return atk*1.5;
        }else{
            System.out.println("You can't use this skill this skill will unlock when you level 5");
            return 0;
        }
    }

    /** Use for unequip sword.
     *  effects: Unequip sword and improve stat of hero
     */
    @Override
    public void unequipSword(){
        equipSword = false;
        atk = Base_ATK + (10*level);
        speed = Max_Speed;
    }
    /** Use for unequip bow.
     *  effects: Unequip bow and improve stat of hero
     */
    @Override
    public void unequipBow(){
        equipBow = false;
        atk = Base_ATK + (10*level);
        speed = Max_Speed;
    }
    /** Use for check when game end.
     * @param w is warrior who is attacked and check when warrior died.
     *  effects: Tell user when warrior are die.
     */
    private void gameEnd(Warrior w){
        if(w.HP <= 0){
            System.out.println("Warrior "+w.name + " died! Warrior "+this.name+" Win!");
        }
    }
    /** Use for check when game end.
     * @param a is archer who is attacked and check when warrior died.
     *  effects: Tell user when warrior are die.
     */
    private void gameEnd(Archer a){
        if(a.HP <= 0){
            System.out.println("Archer "+a.name + " died! Warrior "+this.name+" Win!");
        }
    }
    /** Use for enhance weapon which this hero equip.
     *  effects: Call enhance function in weapon interface and increase any stat that relative with weapon.
     */
    @Override
    public void enhance(){
        if(equipSword && !equipBow){
            s1.enhance();
            atk = Base_ATK + (2.5*level) + s1.getAtk();
            speed = speed - s1.getReduceSpeed();
        }
        if(!equipSword && equipBow){
            b1.enhance();
            atk = Base_ATK + (2.5*level) + (double)(1/2)*b1.getAtk();
            speed = speed - b1.getReduceSpeed();
        }
    }
}
