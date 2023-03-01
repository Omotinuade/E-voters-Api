package data.repositories;

import data.model.Candidate;
import data.model.VoteForm;

import java.util.ArrayList;
import java.util.List;

public class VoteFormRepositoryImpl implements VoteFormRepository{
    private int count;
    private List<VoteForm> forms = new ArrayList<>();

    @Override
    public VoteForm save(VoteForm form) {
        if(form.getId()==0) saveNew(form);
        return form;
    }

    private void saveNew(VoteForm form) {
        form.setId(count+1);
        forms.add(form);
        count++;
    }

    @Override
    public VoteForm findById(int id) {
        for(var eachForm: forms) if(eachForm.getId()==id) return eachForm;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<VoteForm> findAll() {
        return forms;
    }

    @Override
    public void delete(VoteForm form) {
        for(var eachForm: forms) if(eachForm.equals(form)) break; forms.remove(form);

        count--;
    }

    @Override
    public void deleteAll() {
        forms.clear();
        count=0;
    }
    @Override
    public VoteForm findByCandidate(Candidate candidate) {
    for(var eachForm:forms) if(eachForm.getChoiceType().equals(candidate)) return eachForm;
    return null;
    }
}
