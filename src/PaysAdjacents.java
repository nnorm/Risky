/**
 * Classe décrivant une matrice d'adjacence des pays. 
 * */
public class PaysAdjacents {
    public static boolean[][] pays; //matrice d'adjacence
    
    /**
     * Méthode de classe initialisant la matrice d'adjacence. 
     * */
    public static void initMatrix() {
        PaysAdjacents.pays = new boolean[42][42]; //initalise un tableau de boolean initialisé à false
        //défini les différentes adjacences entre les pays qui le sont
        PaysAdjacents.pays[0][1] = true;
        PaysAdjacents.pays[0][2] = true;
        PaysAdjacents.pays[1][2] = true;
        PaysAdjacents.pays[1][3] = true;
        PaysAdjacents.pays[2][3] = true;
        PaysAdjacents.pays[2][20] = true;
        PaysAdjacents.pays[3][4] = true;
        PaysAdjacents.pays[4][5] = true;
        PaysAdjacents.pays[4][6] = true;
        PaysAdjacents.pays[5][6] = true;
        PaysAdjacents.pays[5][7] = true;
        PaysAdjacents.pays[5][8] = true;
        PaysAdjacents.pays[6][7] = true;
        PaysAdjacents.pays[6][9] = true;
        PaysAdjacents.pays[7][8] = true;
        PaysAdjacents.pays[7][9] = true;
        PaysAdjacents.pays[7][10] = true;
        PaysAdjacents.pays[7][11] = true;
        PaysAdjacents.pays[8][10] = true;
        PaysAdjacents.pays[8][12] = true;
        PaysAdjacents.pays[9][11] = true;
        PaysAdjacents.pays[10][11] = true;
        PaysAdjacents.pays[10][12] = true;
        PaysAdjacents.pays[11][13] = true;
        PaysAdjacents.pays[12][36] = true;
        PaysAdjacents.pays[13][14] = true;
        PaysAdjacents.pays[13][15] = true;
        PaysAdjacents.pays[14][15] = true;
        PaysAdjacents.pays[14][16] = true;
        PaysAdjacents.pays[14][17] = true;
        PaysAdjacents.pays[15][17] = true;
        PaysAdjacents.pays[15][18] = true;
        PaysAdjacents.pays[16][17] = true;
        PaysAdjacents.pays[16][19] = true;
        PaysAdjacents.pays[16][20] = true;
        PaysAdjacents.pays[17][18] = true;
        PaysAdjacents.pays[17][19] = true;
        PaysAdjacents.pays[18][19] = true;
        PaysAdjacents.pays[18][22] = true;
        PaysAdjacents.pays[18][27] = true;
        PaysAdjacents.pays[18][28] = true;
        PaysAdjacents.pays[19][20] = true;
        PaysAdjacents.pays[19][21] = true;
        PaysAdjacents.pays[19][22] = true;
        PaysAdjacents.pays[20][21] = true;
        PaysAdjacents.pays[20][23] = true;
        PaysAdjacents.pays[20][24] = true;
        PaysAdjacents.pays[21][22] = true;
        PaysAdjacents.pays[21][24] = true;
        PaysAdjacents.pays[22][24] = true;
        PaysAdjacents.pays[22][27] = true;
        PaysAdjacents.pays[22][29] = true;
        PaysAdjacents.pays[23][24] = true;
        PaysAdjacents.pays[23][25] = true;
        PaysAdjacents.pays[24][25] = true;
        PaysAdjacents.pays[24][26] = true;
        PaysAdjacents.pays[25][26] = true;
        PaysAdjacents.pays[27][28] = true;
        PaysAdjacents.pays[27][29] = true;
        PaysAdjacents.pays[27][30] = true;
        PaysAdjacents.pays[28][30] = true;
        PaysAdjacents.pays[28][31] = true;
        PaysAdjacents.pays[29][31] = true;
        PaysAdjacents.pays[29][32] = true;
        PaysAdjacents.pays[30][31] = true;
        PaysAdjacents.pays[30][33] = true;
        PaysAdjacents.pays[30][34] = true;
        PaysAdjacents.pays[30][35] = true;
        PaysAdjacents.pays[31][32] = true;
        PaysAdjacents.pays[31][35] = true;
        PaysAdjacents.pays[32][38] = true;
        PaysAdjacents.pays[33][34] = true;
        PaysAdjacents.pays[33][36] = true;
        PaysAdjacents.pays[34][35] = true;
        PaysAdjacents.pays[34][36] = true;
        PaysAdjacents.pays[35][36] = true;
        PaysAdjacents.pays[35][37] = true;
        PaysAdjacents.pays[36][37] = true;
        PaysAdjacents.pays[38][39] = true;
        PaysAdjacents.pays[38][40] = true;
        PaysAdjacents.pays[39][40] = true;
        PaysAdjacents.pays[39][41] = true;
        PaysAdjacents.pays[40][41] = true;

        //finis de remplir les cases de manière à avoir une symétrie sur les adjacences
        for (int i = 0; i < 42 ; i++)
            for(int j = 0; j < 42; j++)
                if(PaysAdjacents.pays[i][j] == true)
                	PaysAdjacents.pays[j][i] = true;
    }
}
