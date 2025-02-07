package ca.bcit.comp2522.lab4;

/**
 * Represents a novel with a title, author, and year published.
 *
 * @author Ruan CHu
 * @author Justin Cardas
 * @version 2025
 */
class Novel
{
    static final int CURRENT_YEAR = 2025;

    private final String title;
    private final String authorName;
    private final int    yearPublished;

    /**
     * Constructs a novel.
     * @param title the title of the book
     * @param authorName the name of the author
     * @param yearPublished the year the book was published (not in the future)
     */
    Novel(final String title,
          final String authorName,
          final int yearPublished)
    {
        validateTitle(title);
        validateAuthorName(authorName);
        validateYearPublished(yearPublished);

        this.title         = title;
        this.authorName    = authorName;
        this.yearPublished = yearPublished;
    }

    private static void validateTitle(final String title)
    {
        //Does this even need validation? (untitled books)
    }

    private static void validateAuthorName(final String authorName)
    {
        //Does this need validation? (Anon authors)
    }

    /*
     * Validates the year isn't past CURRENT_YEAR
     * @param yearPublished the year to check
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if(yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year given is past " + CURRENT_YEAR);
        }
    }

    /**
     * Gets the title of the book.
     *
     * @return the title of the book as a String.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author's name.
     *
     * @return the author's name as a String.
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Gets the year the book was published.
     *
     * @return the year the book was published as an integer.
     */
    public int getYearPublished() {
        return yearPublished;
    }
}
