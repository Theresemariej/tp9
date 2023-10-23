package champollion;
import java.util.*; 

public class Enseignant extends Personne {
    ArrayList<ServicePrevu> service =  new ArrayList<>() ; 
    ArrayList<Intervention> inter = new ArrayList<>();
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int TD = 0 ; 
        for(ServicePrevu s : service ) {
         TD += s.getCM () *1.5 ;    
         TD += s.getTP () *0.75 ; 
         TD += s.getTD () ; 

        }
        return Math.round(TD) ; 

        // TODO: Implémenter cette méthode
  
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
        // TODO: Implémenter cette méthode
         public int heuresPrevuesPourUE(UE ue) {
        int TD = 0 ; 
        for(ServicePrevu s : service ) {
            if (ue.equals(s.getUe())){

         TD += s.getCM () *1.5 ;    
         TD += s.getTP () *0.75 ; 
         TD += s.getTD () ; 
                 }
        }
        return TD ; 

    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int CM, int TD, int TP) {
        // TODO: Implémenter cette méthode (int CM, int TD, int TP,UE ue, Enseignant e){
        ServicePrevu sp = new ServicePrevu ( CM, TD, TP, ue, this) ; 
      service.add(sp) ; 
    }


public void ajouteIntervention (Salle s, UE ue, Date deb, int d, TypeIntervention type){
Intervention in = new Intervention (s, ue, this,  deb, d, type) ; 
  inter.add(in) ; 
}

public boolean sousService () {

if (this.heuresPrevues () < 192) {
return true ; 
}
else return false ; 
}

}
