
package uk.co.it.modular.hamcrest.date;

import static uk.co.it.modular.hamcrest.date.DateFormatter.*;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same instant down to the millisecond as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameInstant extends TypeSafeDiagnosingMatcher<Date> {

	private final Date expected;

	public IsSameInstant(final Date expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		if (expected.getTime() != actual.getTime()) {
			mismatchDesc.appendText("date is ").appendValue(formatDateWithMillis(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as ").appendValue(formatDateWithMillis(expected));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same instant as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameInstant(final Date date) {
		return new IsSameInstant(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same UTC instant as the reference UTC epoch time supplied
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(1325415600000L))
	 * </pre>
	 * 
	 * @param timestamp
	 *            the time as milliseconds since the Unix epoch time
	 */
	@Factory
	public static Matcher<Date> sameInstant(final long timestamp) {
		return new IsSameInstant(new Date(timestamp));
	}

}