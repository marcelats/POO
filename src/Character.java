import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character implements Cloneable {
    // Atributos sao protected pois precisam ser acessados pelas classes filhas
    protected int maxHp, hp, level, maxXp, xp, atk, def, agi, con;
    // Instância que não será modificada
    private final String name, charClass, owner;
    protected final Util util = new Util();
    private boolean inBattle;

    // Construtor (recebe o nome do personagem e o nome da classe que ira aparecer na "interface" do jogo)
    public Character(String name, String charClass, String owner) {
        this.name = name;
        this.charClass = charClass;
        this.owner = owner;
        // Valores iniciais que sao fixos para todos os personagens
        this.maxXp = 200;
        this.xp = 100;
        this.level = 1;
    }

    // Getters
    public int getMaxHp() { return this.maxHp; }
    public int getHp() { return this.hp; }
    public int getLv() { return this.level; }
    public int getXp() { return this.xp; }
    public int getAtk() { return this.atk; }
    public int getDef() { return this.def; }
    public int getAgi() { return this.agi; }
    public int getCon() { return this.con; }
    public String getName() { return this.name; }
    public String getCharClass() { return this.charClass; }
    public String getOwner() { return owner; }

    // Setters
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
    public void setHp(int hp) { this.hp = hp; }
    public void setLevel(int level) { this.level = level; }
    public void setXp(int xp) { this.xp = xp; }
    public void setAtk(int atk) { this.atk = atk; }
    public void setDef(int def) { this.def = def; }
    public void setAgi(int agi) { this.agi = agi; }
    public void setCon(int con) { this.con = con; }

    public boolean isAlive(){
        return this.hp > 0;
    }
    public boolean isDead(){
        return this.hp <= 0;
    }
    public boolean isInBattle(){
        return inBattle;
    }
    public void putInBattle(){
        this.inBattle = true;
    }
    public void putOutOffBattle(){
        this.inBattle = false;
    }
    public void action(Character target, ArrayList<Character> hisDeck){
        // Se o personagem em batalha for um sacerdote
        if (this instanceof Priest){
            ((Priest) this).heal(hisDeck);
        }
        else{
            this.attack(target);
        }
    }
    public void attack(Character target) {
        System.out.println("("+this.owner+") "+this.name+" ataca");
        util.sleep(2); // Pequena pausa para leitura do usuario
        // Calcula o dano
        int damage = this.atk - target.def;
        // Aplica dano no alvo
        target.takeDamage(damage);
    }
    public void heal(int amount){
        // Se nao ultrapassar o valor maximo
        if (this.hp+amount <= this.maxHp){
            this.hp += amount;
        }
        else{
            this.hp = this.maxHp;
        }
    }
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.isAlive()){
            System.out.println(this.name+" sofreu "+damage+" de dano, ficando com "+this.getHp()+" de HP");
        }else{
            System.out.println(this.name+" foi morto");
        }
        util.sleep(2); // Pequena pausa para leitura do usuario
        System.out.println();
    }
    public void printCharInformation(){
        System.out.println(this.name+" ("+this.charClass+") Lv: "+this.level+"    XP: "+this.xp+"/"+this.maxXp);
        // Se for um sacerdote
        if (this instanceof Priest){
            System.out.println("HP: "+this.hp+"/"+this.maxHp+"    Fe: " +((Priest) this).faith+"    Def: "+this.def+"    Agi: "+this.agi+"    Con: "+this.con);
        }
        else{
            System.out.println("HP: "+this.hp+"/"+this.maxHp+"    Atk: " +this.atk+"    Def: "+this.def+"    Agi: "+this.agi+"    Con: "+this.con);
        }
    }
    public void levelUp(){
        this.level++;
        this.maxHp *= 1.2;
        // Se o hp atual for menor que 30% do hp maximo, recupera o hp ate esse valor
        if (this.hp < this.maxXp * 0.3){ this.hp = (int) (this.maxHp * 0.3); }
        this.maxXp *= 2;
        this.atk *= 1.15;
        this.def *= 1.15;
        this.con *= 1.75;
        this.agi *= 1.15;
        System.out.println();
        System.out.println(this.name+" subiu para o nível "+this.level+"!");
        util.sleep(2); // Pequena pausa para leitura do usuario
    }
    public void stealXP(Character target){
        this.xp += target.xp;
        //  Sobe o personagem de level quando o valor de xp atinge seu valor máximo
        while (this.xp >= this.maxXp) {
            this.levelUp();
        }
    }
}