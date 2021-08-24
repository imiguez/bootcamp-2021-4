package junit.imiguez;

public class Fighter {

    public static void main(String[] args) {
        Fighter p1 = new Fighter("Pepe", 501, 100);
        Fighter p2 = new Fighter("Juan", 601, 100);
        System.out.println(p1.fight(p2));
    }

    /*
    Create a function that returns the name of the winner in a fight between two fighters.
    Each fighter takes turns attacking the other and whoever kills the other first is victorious.
    Death is defined as having health <= 0.
     */

    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public String fight(Fighter enemy) {
        int turn = 0;
        while (health > 0 && enemy.health > 0) {
            if (turn % 2 == 0)
                enemy.health -= this.damagePerAttack;
            else
                health -= enemy.damagePerAttack;
            if (health <= 0)
                return enemy.name+" gana.";
            else if (enemy.health <= 0)
                return name+" gana.";
            System.out.println(name+" tiene "+health+" de vida.");
            System.out.println(enemy.name+" tiene "+enemy.health+" de vida.");
            turn++;
        }
        return "Empate.";
    }



    public void attack(Fighter enemy) {
        if (this.health <= 0 || enemy.health <= 0)
            return;
        System.out.println(enemy.name+"´s health: "+enemy.health);
        enemy.health = enemy.health - this.damagePerAttack;
        if (enemy.health <= 0)
            System.out.printf(this.name+" attacks, "+enemy.name+" die.");
        else
            System.out.printf(this.name+" attacks, "+enemy.name+" health:"+enemy.health);
    }

}