package br.com.guilhermebehs.school.gamification.domain.trophy;

import br.com.guilhermebehs.school.shared.domain.Cpf;

import java.util.List;

public interface TrophyRepository {

    void addTrophyToCpf(Trophy trophy);
    List<Trophy> findByTrophyName(String name);
    List<Trophy> findByCpf(Cpf cpf);
}
