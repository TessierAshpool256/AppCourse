package org.appcourse.course.usecase

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

        // There should have been login business logic here, but it isn’t described in the test.

        return Result.success(login)
    }
}