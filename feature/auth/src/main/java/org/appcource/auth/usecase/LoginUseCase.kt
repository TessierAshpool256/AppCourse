package org.appcource.auth.usecase

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
    operator fun invoke(
        login: String,
        password: String
    ) : Result<String> {

        return Result.success(login)
    }
}
