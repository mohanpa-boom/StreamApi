package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

// First U Create the PredicateTest class

public class PredicateTest {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		List<String> names = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah",
				"allessandra", "allianna", "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle",
				"annebelle");
		names.stream()
		.filter(Filter.nameStartingWithPrefix("ana"))
		.map(Mapper.getDistinctCharactersCount())
		.forEachOrdered(System.out::println);
		}
	}

//Filter class with methodPredicate<String>nameStartingWithPrefix(String prefix) //
//that returns a predicate tocheck whether a name string starts with the given prefix or not.//

class Filter {
	public static Predicate<? super String> nameStartingWithPrefix(String p)
	{
		return v->v.startsWith(p);
		}
	}

//Mapper class with methodFunction<String, CharactersCount>getDistinctCharactersCount() //
//that returns a mapper function toreturn a CharactersCount class object that correspond to the givenname string.//

class Mapper {
	public static Function<String, CharactersCount> getDistinctCharactersCount()
	{
		return v->
		{
			Set<Character> chars = new HashSet<Character>();
			for(char c: v.toCharArray())
			{
				chars.add(new Character(c));
				}
			return new CharactersCount(v, chars.size());
			};
			}
	}
class CharactersCount
{
	private final String name;
	private final Integer distinctCharacterCount;
	public CharactersCount(String name, Integer distinctCharacterCount)
	{
		this.name = name;
		this.distinctCharacterCount = distinctCharacterCount;
		}
	@Override
	public String toString()
	{
		return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
		}
	}
	
