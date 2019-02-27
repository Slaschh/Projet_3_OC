package Affichage;

public enum Color

{

// on entre une lettre que l'on convertit en nombre
// on convertie un nombre en mots

    W (0,"Blanc"),
    N (1,"Noir"),
    R (2,"Rouge"),
    V (3,"Vert"),
    O (4,"Orange"),
    J (5,"Jaune"),
    G (6,"Gris"),
    M (7,"Majenta"),
    P (8,"Rose"),
    B (9,"Bleu");

    private Integer Number;
    private String couleur = "" ;

Color(Integer Number, String couleur)
{
    this.Number = Number;
    this.couleur = couleur;
}

    public Integer getNumber() {
        return Number;
    }

    public void getCouleur (String couleur) {
        this.couleur = couleur;
    }
}
