package org.appcource.auth.domain.usecase

import javax.inject.Inject


class LoginUseCase @Inject constructor() {
    /**
     * LoginUseCase
     *
     * @param login
     * @param password
     *
     * @return корректный логин
     */
    suspend operator fun invoke(
        login: String,
        password: String
    ) : Result<String> {
//        TODO("")
        return Result.success("")
    }
}
