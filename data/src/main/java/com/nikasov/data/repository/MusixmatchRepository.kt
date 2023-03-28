package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.data.api.CompletionsApi
import javax.inject.Inject

class MusixmatchRepository @Inject constructor(
    private val completionsApi: CompletionsApi
) : BaseRepository() {


}