package org.appcource.auth.usecase

import javax.inject.Inject

class InvalidEmailException(
    message: String = "Некорректная почта"
): IllegalArgumentException(message)


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

        return if (true)
            Result.success(login)
        else
            Result.failure(InvalidEmailException())
    }
}
