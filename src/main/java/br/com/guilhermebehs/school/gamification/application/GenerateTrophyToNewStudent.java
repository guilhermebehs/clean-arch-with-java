package br.com.guilhermebehs.school.gamification.application;

import br.com.guilhermebehs.school.gamification.domain.trophy.Trophy;
import br.com.guilhermebehs.school.gamification.domain.trophy.TrophyRepository;
import br.com.guilhermebehs.school.shared.domain.Cpf;
import br.com.guilhermebehs.school.shared.domain.event.Event;
import br.com.guilhermebehs.school.shared.domain.event.EventListener;

import static br.com.guilhermebehs.school.shared.domain.event.EventType.STUDENT_HAS_BEEN_ENROLLED;

public class GenerateTrophyToNewStudent extends EventListener {

    private final TrophyRepository trophyRepository;

    public GenerateTrophyToNewStudent(TrophyRepository trophyRepository) {
        this.trophyRepository = trophyRepository;
    }

    @Override
    protected void reactTo(Event event) {
        var info = (Cpf)event.info().get("cpf");
        var newTrophy = new Trophy(info,"Beginner");
        trophyRepository.addTrophyToCpf(newTrophy);
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event.type().equals(STUDENT_HAS_BEEN_ENROLLED);
    }
}
