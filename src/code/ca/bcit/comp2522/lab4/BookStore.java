package ca.bcit.comp2522.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a BookStore with a name, and a list of {@link Novel}s.
 *
 * @author Ruan Chu
 * @author Justin Cardas
 * @version 2025
 */
public class BookStore
{

    private static final int DECADE_DIFFERENCE = 10;
    private static final int FIRST_NOVEL = 0;

    private final String name;
    private final List<Novel> novels;


    /**
     * Constructs a BookStore with a given name and list of {@link Novel}s.
     *
     * @param name   the name of the bookstore
     * @param novels a list of novels in the bookstore
     * @throws IllegalArgumentException if the name is null or empty
     */
    public BookStore(final String name, final List<Novel> novels)
    {
        validateName(name);
        this.name = name;
        this.novels = novels;
    }

    /**
     * Validates the bookstore's name.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if the name is null or empty
     */
    private void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
     * Prints all {@link Novel} titles in uppercase.
     * If no novels are found, prints "No novels found".
     */
    public void printAllTitles()
    {
        if (novels.isEmpty())
        {
            System.out.println("No novels found");
        } else
        {
            for (Novel novel : novels)
            {
                System.out.println(novel.getTitle().toUpperCase());
            }
        }
    }

    /**
     * Prints the titles of {@link Novel}s that contain a specified title fragment (case-insensitive).
     *
     * @param title the title fragment to search for
     */
    public void printBookTitle(final String title)
    {
        if (novels.isEmpty())
        {
            System.out.println("No novels found");
        } else
        {
            for (Novel novel : novels)
            {
                if (novel.getTitle().toLowerCase().contains(title.toLowerCase()))
                {
                    System.out.println(novel.getTitle());
                }
            }
        }

    }

    /**
     * Prints all {@link Novel} titles in alphabetical order.
     * If no novels are found, prints "No novels found".
     */
    public void printTitlesInAlphaOrder()
    {
        if (novels.isEmpty())
        {
            System.out.println("No novels found");
        } else
        {
            Novel[] novelArray = novels.toArray(new Novel[FIRST_NOVEL]);

            Arrays.sort(novelArray, (n1, n2) -> n1.getTitle().compareTo(n2.getTitle()));

            for (Novel novel : novelArray)
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Prints the titles of novels from a specific decade.
     *
     * @param decade the decade to filter novels by (e.g., 1990 for the 1990s)
     */
    public void printGroupByDecade(final int decade)
    {
        if (novels.isEmpty())
        {
            System.out.println("No novels found");
        } else
        {
            List<Novel> decadeNovels = new ArrayList<>();

            for (Novel novel : novels)
            {
                int year = novel.getYearPublished();
                if (year >= decade && year < decade + DECADE_DIFFERENCE)
                {
                    decadeNovels.add(novel);
                }
            }

            if (decadeNovels.isEmpty())
            {
                System.out.println("No novels found from the " + decade + "s.");
            } else
            {
                for (Novel novel : decadeNovels)
                {
                    System.out.println(novel.getTitle());
                }
            }
        }
    }

    /**
     * Prints the title of the novel with the longest title.
     * If no novels are found, prints "No novels found".
     */
    public void getLongest()
    {
        if (novels.isEmpty())
        {
            System.out.println("No novels found");
        } else
        {
            Novel longestNovel = novels.get(FIRST_NOVEL); // Get the first novel as the initial longest
            for (Novel novel : novels)
            {
                if (novel.getTitle().length() > longestNovel.getTitle().length())
                {
                    longestNovel = novel; // Update if a longer title is found
                }
            }
            System.out.println(longestNovel.getTitle());
        }
    }

    public static void main(final String[] args)
    {

    }
}
