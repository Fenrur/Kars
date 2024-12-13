package fr.kars.uc.impl

import fr.kars.PartyId
import fr.kars.ProfileId
import fr.kars.ProfilePartyEvaluationComment
import fr.kars.ProfilePartyEvaluationRate
import fr.kars.jooq.tables.daos.ProfileEvaluatePartyDao
import fr.kars.jooq.tables.pojos.ProfileEvaluateParty
import fr.kars.uc.ProfileEvaluatePartyUseCase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseProfileEvaluatePartyUseCase(private val profileEvaluatePartyDao: ProfileEvaluatePartyDao) : ProfileEvaluatePartyUseCase {

    override fun invoke(
        evaluatedProfileId: ProfileId,
        evaluatorProfileId: ProfileId,
        partyId: PartyId,
        rate: ProfilePartyEvaluationRate,
        comment: ProfilePartyEvaluationComment?
    ) {
        profileEvaluatePartyDao.insert(ProfileEvaluateParty(evaluatedProfileId, evaluatorProfileId, partyId, rate, comment))
    }
}