package object;

import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Extrait extends ExtraitDAO{
    private Connection conn;
    private ResultSet resultSet;
    private boolean existe=false;
    private final SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
    
    private int num, sexe;
    private Date dateNaiss, dateDeliv;
    private String nomE, prenomE, lieuNaiss, nomP, prenomP, domicileP, proffessionP, nomM, prenomM, domicileM, proffessionM; 

    public boolean getExiste() {
        return existe;
    }
    
    public SimpleDateFormat getDateFor() {
        return DateFor;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getDateDeliv() {
        return dateDeliv;
    }

    public void setDateDeliv(Date dateDeliv) {
        this.dateDeliv = dateDeliv;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getDomicileP() {
        return domicileP;
    }

    public void setDomicileP(String domicileP) {
        this.domicileP = domicileP;
    }

    public String getProffessionP() {
        return proffessionP;
    }

    public void setProffessionP(String proffessionP) {
        this.proffessionP = proffessionP;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public String getDomicileM() {
        return domicileM;
    }

    public void setDomicileM(String domicileM) {
        this.domicileM = domicileM;
    }

    public String getProffessionM() {
        return proffessionM;
    }

    public void setProffessionM(String proffessionM) {
        this.proffessionM = proffessionM;
    }

    public Extrait(int num, int sexe, Date dateNaiss, Date dateDeliv, String nomE, String prenomE, String lieuNaiss, String nomP, String prenomP, String domicileP, String proffessionP, String nomM, String prenomM, String domicileM, String proffessionM) {
        this.num = num;
        this.sexe = sexe;
        this.dateNaiss = dateNaiss;
        this.dateDeliv = dateDeliv;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.lieuNaiss = lieuNaiss;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.domicileP = domicileP;
        this.proffessionP = proffessionP;
        this.nomM = nomM;
        this.prenomM = prenomM;
        this.domicileM = domicileM;
        this.proffessionM = proffessionM;

        String dbName="mairiedb";
        String urlBDD= "jdbc:mysql://localhost:3306/"+dbName;
        String user= "root";
        String passwd = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(urlBDD, user, passwd);
            System.out.println("Connexion reussi");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur de connexion");
        }

        this.verifier();
    }
    
    public Extrait(int num) {
        this.num = num;

        String dbName="mairiedb";
        String urlBDD= "jdbc:mysql://localhost:3306/"+dbName;
        String user= "root";
        String passwd = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(urlBDD, user, passwd);
            System.out.println("Connexion reussi");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur de connexion");
        }

        if(this.verifier()){
            try{
                this.nomE=this.resultSet.getString("nomE");
                this.prenomE=this.resultSet.getString("prenomE");
                this.dateNaiss=new SimpleDateFormat("yyyy-MM-dd").parse(this.resultSet.getString("dateNaiss"));
                this.dateDeliv=new SimpleDateFormat("yyyy-MM-dd").parse(this.resultSet.getString("dateDeliv"));
                this.lieuNaiss=this.resultSet.getString("lieuNaiss");
                this.sexe=Integer.valueOf(this.resultSet.getString("sexe"));
                this.nomP=this.resultSet.getString("nomP");
                this.prenomP=this.resultSet.getString("prenomP");
                this.domicileP=this.resultSet.getString("domicileP");
                this.proffessionP=this.resultSet.getString("proffessionP");
                this.nomM=this.resultSet.getString("nomM");
                this.prenomM=this.resultSet.getString("prenomM");
                this.domicileM=this.resultSet.getString("domicileM");
                this.proffessionM=this.resultSet.getString("proffessionM");
                this.existe=true;
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("Cet extrait nexiste pas surement");
            }
        }
    }

    /**
     * modifier l'element de la base de donnee
     * @return true si reussie et false si echoue
     */
    @Override
    public boolean modifier() {
        // TODO Auto-generated method stub
        String query= "UPDATE extrait SET num=?, nomE=?, prenomE=?, dateNaiss=?, lieuNaiss=?, sexe=?, nomP=?, prenomP=?, domicileP=?, proffessionP=?, nomM=?, prenomM=?, domicileM=?, proffessionM=?, dateDeliv=? WHERE num=?";
        try{
            if(this.existe){
                PreparedStatement state= conn.prepareStatement(query);
                int compteur_tmp=1;
                state.setInt(compteur_tmp++, this.num);
                state.setString(compteur_tmp++, this.nomE);
                state.setString(compteur_tmp++, this.prenomE);
                state.setString(compteur_tmp++, this.DateFor.format(this.dateNaiss));
                state.setString(compteur_tmp++, this.lieuNaiss);
                state.setInt(compteur_tmp++, this.sexe);
                state.setString(compteur_tmp++, this.nomP);
                state.setString(compteur_tmp++, this.prenomP);
                state.setString(compteur_tmp++, this.domicileP);
                state.setString(compteur_tmp++, this.proffessionP);
                state.setString(compteur_tmp++, this.nomM);
                state.setString(compteur_tmp++, this.prenomM);
                state.setString(compteur_tmp++, this.domicileM);
                state.setString(compteur_tmp++, this.proffessionM);
                state.setString(compteur_tmp++, this.DateFor.format(this.dateDeliv));
                state.setInt(compteur_tmp++, this.num);
    
                if(state.executeUpdate()>0){
                    System.out.println("Suppression reussie");
                    return true;
                }
                else{
                    System.out.println("Supression echouer");
                    return false;
                }
            }
            else{
                return false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Une erreur est survenue");
            return false;
        }
        // TODO Auto-generated method stub
    }

    /**
     * Supprime l'element de la base de donnee
     * @return true si reussie et false si echoue
     */
    @Override
    public boolean supprimer() {
        // TODO Auto-generated method stub
        String query= "DELETE FROM extrait WHERE num=?";
        try{
            if(this.existe){
                PreparedStatement state= conn.prepareStatement(query);
                state.setInt(1, this.num);
                if(state.executeUpdate()>0){
                    System.out.println("Suppression reussie");
                    return true;
                }
                else{
                    System.out.println("Supression echouer");
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Une erreur est survenue");
            return false;
        }
    }
    
    /**
     * ajouter l'element de la base de donnee
     * @return true si reussie et false si echoue
     */
    @Override
    public boolean ajouter() {
        // TODO Auto-generated method stub
        String query= "INSERT INTO extrait VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            if(this.verifier()){
                return false;
            }
            else{
                PreparedStatement state= conn.prepareStatement(query);
                int compteur_tmp=1;
                state.setInt(compteur_tmp++, this.num);
                state.setString(compteur_tmp++, this.nomE);
                state.setString(compteur_tmp++, this.prenomE);
                state.setString(compteur_tmp++, this.DateFor.format(this.dateNaiss));
                state.setString(compteur_tmp++, this.lieuNaiss);
                state.setInt(compteur_tmp++, this.sexe);
                state.setString(compteur_tmp++, this.nomP);
                state.setString(compteur_tmp++, this.prenomP);
                state.setString(compteur_tmp++, this.domicileP);
                state.setString(compteur_tmp++, this.proffessionP);
                state.setString(compteur_tmp++, this.nomM);
                state.setString(compteur_tmp++, this.prenomM);
                state.setString(compteur_tmp++, this.domicileM);
                state.setString(compteur_tmp++, this.proffessionM);
                state.setString(compteur_tmp++, this.DateFor.format(new Date()));
    
                if(state.executeUpdate()>0){
                    System.out.println("Ajoue reussie");
                    return true;
                }
                else{
                    System.out.println("Ajoue echouer");
                    return false;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Une erreur est survenue");
            return false;
        }
    }

    /**
     * verifier si l'element est dans la base de donnee
     * @return true si reussie et false si echoue
     */
    @Override
    public boolean verifier() {
        String query= "SELECT * FROM extrait WHERE num=?";
        try{
            PreparedStatement state= conn.prepareStatement(query);
            state.setInt(1, this.num);
            this.resultSet=state.executeQuery();
            if(this.resultSet.next()){
                System.out.println(" existe");
                this.existe=true;
                return true;
            }
            else{
                System.out.println("existe pas");
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Une erreur est survenue");
            return false;
        }
    }
    
}
