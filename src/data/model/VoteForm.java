package data.model;

import java.util.HashMap;
import java.util.List;

public class VoteForm {


    private String title;
    private int id;
    private Candidate choiceType;
    private int choiceCount;
    private int userId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidate getChoiceType() {
        return choiceType;
    }

    public void setChoiceType(Candidate choiceType) {
        this.choiceType = choiceType;
    }

    public int getChoiceCount() {
        return choiceCount;
    }

    public HashMap<String, String> GetCandidates(){
        var candidates = new HashMap<String , String>();
        candidates.put("1", "Balablu");
        candidates.put("2", "Peter Obi");

        return candidates;
    }

    public void DisplayCandidates(){
        System.out.printf("Candidates");
        var candidates = GetCandidates();
        for (var candidate: candidates.entrySet()) {
            System.out.printf(candidate.getKey()+  "-"+candidate.getValue());


        }
    }

}
