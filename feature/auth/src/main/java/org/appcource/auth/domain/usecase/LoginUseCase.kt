package org.appcource.auth.domain.usecase

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
        val emailRegex = Regex(
            "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])\$\n",
            RegexOption.COMMENTS
        )

        return if (emailRegex.matches(login))
            Result.success(login)
        else
            Result.failure(InvalidEmailException())
    }
}
