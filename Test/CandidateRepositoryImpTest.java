import data.model.Candidate;
import data.repositories.CandidateRepository;
import data.repositories.CandidateRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CandidateRepositoryImpTest {

        private CandidateRepository candidateRepository;
        private Candidate candidate;

        @BeforeEach
        public void setUp() {
            candidateRepository = new CandidateRepositoryImpl();
            candidate = new Candidate();
            candidate.setName("BalaBlu");
            candidate.setPartyName("PDAPC");
        }

        @Test
        public void saveOneCandidate_countIsOneTest() {
            candidateRepository.save(candidate);
            assertEquals(1, candidateRepository.count());
        }

        @Test
        public void saveOneCandidate_idOfCandidateIsOneTest() {
            Candidate savedCandidate = candidateRepository.save(candidate);
            assertEquals(1, savedCandidate.getId());
        }

        @Test
        @DisplayName("Update Candidate test")
        public void saveTwoCandidatesWithSameId_countIsOneTest() {
            Candidate savedCandidate = candidateRepository.save(candidate);
            assertEquals(1, candidateRepository.count());
            savedCandidate.setName("Ashiwaju");
            candidateRepository.save(savedCandidate);
            assertEquals(1, candidateRepository.count());

        }

        @Test
        public void saveOneCandidate_findCandidateByIdTest() {
            Candidate savedCandidate = candidateRepository.save(candidate);
            assertEquals(1, savedCandidate.getId());
            Candidate foundCandidate = candidateRepository.findById(1);
            assertEquals(foundCandidate, savedCandidate);
        }

        @Test
        public void saveOneCandidate_deleteOneCandidateTest() {
            candidateRepository.save(candidate);
            assertEquals(1, candidateRepository.count());
            candidateRepository.delete(candidate);
            assertEquals(0, candidateRepository.count());
        }

        @Test
        public void saveOneCandidate_deleteOneCandidate_countIsZeroTest() {
            candidateRepository.save(candidate);
            assertEquals(1, candidateRepository.count());
            candidateRepository.delete(1);
            assertEquals(0, candidateRepository.count());
        }

        @Test
        public void saveThreeCandidates_findThreeCandidates_countIsThreeTest() {
            candidateRepository.save(candidate);
            Candidate candidate1 = new Candidate();
            Candidate candidate2 = new Candidate();
            candidateRepository.save(candidate1);
            candidateRepository.save(candidate2);
            assertEquals(3, candidateRepository.count());
            List<Candidate> list;
            list = candidateRepository.findAll();
            assertEquals(3, list.size());
            assertTrue(list.contains(candidate));
            assertTrue(list.contains(candidate1));
            assertTrue(list.contains(candidate2));
        }

        @Test
        public void saveThreeCandidates_deleteAll_countIsZeroTest() {
            candidateRepository.save(candidate);
            Candidate candidate1 = new Candidate();
            Candidate candidate2 = new Candidate();
            candidateRepository.save(candidate1);
            candidateRepository.save(candidate2);
            candidateRepository.deleteAll();
            assertEquals(0, candidateRepository.count());
        }
    }



