/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recommendation;

import controller.Controller;
import domain.Recommendation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Nemanja
 */
public class SaveRecommendationSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Recommendation)){
            throw new Exception("Objekat nije preporuka");
        }
        Recommendation recommendation = (Recommendation) param;
        if(doesExist(recommendation)){
            throw new Exception("Preporuka vec postoji");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((Recommendation)param);
    }

    private boolean doesExist(Recommendation recommendation) {
        List<Recommendation> recommendations = new ArrayList<>();
        try {
            recommendations=Controller.getInstance().getAllRecommendations();
        } catch (Exception ex) {
            Logger.getLogger(SaveRecommendationSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Recommendation recommendationHelp : recommendations) {
            if(recommendationHelp.getWorkerID()==recommendation.getWorkerID()
                    && recommendationHelp.getArticleID()==recommendation.getArticleID()){
                return true;
            }
        }
        return false;
    }
    
}
