package string.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherCase {


	private List<String> group(String regex, String text) {
		return group(regex, text, 0);
	}

	private List<String> group(String regex, String text, int groupIndex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		List<String> result = new ArrayList<>();
		while(matcher.find()) {
			result.add(matcher.group(groupIndex));
		}
		return result;
	}



	public static void main(String[] args) {
		MatcherCase matcherCase = new MatcherCase();

		String text = "Core support for dependency injection! transaction management! web applications! data access! messaging! testing and more.";

		System.out.println("\\w".matches("\\w"));
		System.out.println(matcherCase.group("\\w+!", text));
		System.out.println(matcherCase.group("(\\w+)!", text, 1));


	}


}
