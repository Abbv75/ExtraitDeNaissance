package object;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extrait extends ExtraitDAO{
    private final SQL_Tools bdd = new SQL_Tools("mairiedb");
    private final SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
    
    private int num, sexe;
    private Date dateNaiss, dateDeliv;
    private String nomE, prenomE, lieuNaiss, nomP, prenomP, domicileP, proffessionP, nomM, prenomM, domicileM, proffessionM; 

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
    }

    @Override
    public boolean modifier() {
        if(!bdd.try_connection()){
            return false;
        }
        else{
            String[] champName= new String[14];
            int tmp_count=0;
            champName[tmp_count++]="num";
            champName[tmp_count++]="nomE";
            champName[tmp_count++]="prenomE";
            champName[tmp_count++]="dateNaiss";
            champName[tmp_count++]="sexe";
            champName[tmp_count++]="nomP";
            champName[tmp_count++]="prenomP";
            champName[tmp_count++]="domicileP";
            champName[tmp_count++]="proffessionP";
            champName[tmp_count++]="nomM";
            champName[tmp_count++]="prenomM";
            champName[tmp_count++]="domicileM";
            champName[tmp_count++]="proffessionM";
            champName[tmp_count++]="dateDeliv";
            
            String[] champValue= new String[14];
            tmp_count=0;
            champName[tmp_count++]=Integer.toString(this.num);
            champName[tmp_count++]=this.nomE;
            champName[tmp_count++]=this.prenomE;
            champName[tmp_count++]=this.DateFor.format(this.dateNaiss);
            champName[tmp_count++]=Integer.toString(this.sexe);
            champName[tmp_count++]=this.nomP;
            champName[tmp_count++]=this.prenomP;
            champName[tmp_count++]=this.domicileP;
            champName[tmp_count++]=this.proffessionP;
            champName[tmp_count++]=this.nomM;
            champName[tmp_count++]=this.prenomM;
            champName[tmp_count++]=this.domicileM;
            champName[tmp_count++]=this.proffessionM;
            champName[tmp_count++]=this.DateFor.format(this.dateDeliv);

            Object primaryKey[]= new Object[1];
            primaryKey[0]="num";
            primaryKey[1]=this.num;
            
            return bdd.edit_from_id("extrait", champName, champValue, primaryKey);
        }
        // TODO Auto-generated method stub
    }

    @Override
    public boolean supprimer() {
        // TODO Auto-generated method stub
        return false;
    }

    public static void main(String[] args) {
        Extrait ext= new Extrait(0, 0, new Date(), new Date(), "null"," null"," null"," null"," null"," null"," null"," null"," null", "null"," null");
        ext.modifier();
    }
    
}
