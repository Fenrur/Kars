package fr.kars.author.uc;

import fr.kars.author.Author

interface FindAllAuthorUseCase {
    operator fun invoke(): List<Author>
}
