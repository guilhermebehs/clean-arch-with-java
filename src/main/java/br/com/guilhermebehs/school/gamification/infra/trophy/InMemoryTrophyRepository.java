package br.com.guilhermebehs.school.gamification.infra.trophy;

import br.com.guilhermebehs.school.shared.domain.Cpf;
import br.com.guilhermebehs.school.gamification.domain.trophy.Trophy;
import br.com.guilhermebehs.school.gamification.domain.trophy.TrophyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTrophyRepository implements TrophyRepository {

    private List<Trophy> trophies = new ArrayList<>();

    @Override
    public void addTrophyToCpf(Trophy trophy) {
        trophies.add(trophy);
    }

    @Override
    public List<Trophy> findByTrophyName(String name) {
        return trophies.stream()
                .filter(trophy -> trophy.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Trophy> findByCpf(Cpf cpf) {
        return trophies.stream()
                .filter(trophy -> trophy.getStudentCpf().equals(cpf))
                .collect(Collectors.toList());
    }
}
