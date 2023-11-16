package model.repository.Sponsor;

import model.entity.Sponsor;
import model.repository.ICrudRepository;

import java.util.List;

public interface ISponsorRepository extends ICrudRepository<Sponsor, Integer> {
    List<Sponsor> getRichSponsor();
}
