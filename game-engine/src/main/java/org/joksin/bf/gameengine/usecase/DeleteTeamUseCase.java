package org.joksin.bf.gameengine.usecase;

import jakarta.validation.Valid;
import org.joksin.bf.gameengine.model.request.DeleteTeamRequest;

public interface DeleteTeamUseCase {

    void delete(@Valid DeleteTeamRequest deleteTeamRequest);
}
