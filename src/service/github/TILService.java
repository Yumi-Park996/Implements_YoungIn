package service.github;

import model.dto.TIL;
import model.dto.Repo;

import java.util.List;

public interface TILService {
    List<TIL> getTIL(Repo repo) ;
}
