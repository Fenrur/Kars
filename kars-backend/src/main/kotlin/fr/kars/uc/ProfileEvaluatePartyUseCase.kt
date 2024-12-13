package fr.kars.uc

import fr.kars.PartyId
import fr.kars.ProfileId
import fr.kars.ProfilePartyEvaluationComment
import fr.kars.ProfilePartyEvaluationRate
import fr.kars.uc.impl.DatabaseProfileEvaluatePartyUseCase

interface ProfileEvaluatePartyUseCase {

    operator fun invoke(
        evaluatedProfileId: ProfileId,
        evaluatorProfileId: ProfileId,
        partyId: PartyId,
        rate: ProfilePartyEvaluationRate,
        comment: ProfilePartyEvaluationComment?
    )
}