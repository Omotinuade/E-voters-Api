import data.model.Candidate;
import data.model.User;
import data.model.VoteForm;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImp;
import data.repositories.VoteFormRepository;
import data.repositories.VoteFormRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VoteFormRepositoryImplTest {
    private VoteFormRepository voteFormRepository;
    private VoteForm voteForm;
    private Candidate candidate;

    @BeforeEach
    public void setUp() {
        voteFormRepository = new VoteFormRepositoryImpl();
        voteForm = new VoteForm();
        voteForm.setTitle("Presidential");
        voteForm.setChoiceType(candidate);
    }

    @Test
    public void saveOneVoteForm_countIsOneTest() {
        voteFormRepository.save(voteForm);
        assertEquals(1, voteFormRepository.count());
    }

    @Test
    public void saveOneVoteForm_idOfUserIsOneTest() {
        VoteForm savedVoteForm = voteFormRepository.save(voteForm);
        assertEquals(1, savedVoteForm.getId());
    }

    @Test
    public void saveTwoUsersWithSameId_countIsOneTest() {
        VoteForm savedVoteForm = voteFormRepository.save(voteForm);
        assertEquals(1, voteFormRepository.count());
        savedVoteForm.setTitle("Presidential Selection");
        voteFormRepository.save(savedVoteForm);
        assertEquals(1, voteFormRepository.count());

    }

    @Test
    public void saveOneUser_findUserByIdTest() {
        VoteForm savedVoteForm = voteFormRepository.save(voteForm);
        assertEquals(1, savedVoteForm.getId());
        VoteForm foundVoteForm = voteFormRepository.findById(1);
        assertEquals(foundVoteForm, savedVoteForm);
    }
//    @Test
//    public void saveOneVoteForm_findVoteFormByCandidateTest() {
//        VoteForm savedVoteForm = voteFormRepository.save(voteForm);
//        assertEquals(1, voteFormRepository.count());
//        VoteForm foundVoteForm = voteFormRepository.findByCandidate(candidate);
//        assertEquals(foundVoteForm, savedVoteForm);}

    @Test
    public void saveOneVoteForm_deleteOneVoteFormTest(){
        VoteForm savedVoteForm= voteFormRepository.save(voteForm);
        assertEquals(1, voteFormRepository.count());
        voteFormRepository.delete(savedVoteForm);
        assertEquals(0, voteFormRepository.count());
    }

    @Test
    public void saveOneUser_deleteOneUser_countIsZeroTest() {
        VoteForm savedVoteForm = voteFormRepository.save(voteForm);
        assertEquals(1, voteFormRepository.count());
        voteFormRepository.delete(savedVoteForm);
        assertEquals(0, voteFormRepository.count());
    }

    @Test
    public void saveThreeVoteForms_findThreeVoteForms_countIsThreeTest() {
        voteFormRepository.save(voteForm);
        VoteForm form1 = new VoteForm();
        VoteForm form2 = new VoteForm();
        voteFormRepository.save(form1);
        voteFormRepository.save(form2);
        assertEquals(3, voteFormRepository.count());
        List<VoteForm> list;
        list = voteFormRepository.findAll();
        assertEquals(3, list.size());
        assertTrue(list.contains(voteForm));
        assertTrue(list.contains(form1));
        assertTrue(list.contains(form2));
    }

    @Test
    public void saveThreeUsers_deleteAll_countIsZeroTest() {
        voteFormRepository.save(voteForm);
        VoteForm form1 = new VoteForm();
        VoteForm form2 = new VoteForm();
        voteFormRepository.save(form1);
        voteFormRepository.save(form2);
        voteFormRepository.deleteAll();
        assertEquals(0, voteFormRepository.count());
    }
}

