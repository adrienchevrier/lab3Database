package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides the application with high-level methods to access the persistent
 * data store. The class hides the fact that data are stored in a RDBMS and also
 * hides all the complex SQL machinery required to access it.
 * <p>
 * The constructor and the methods of this class all throw a
 * {@link DataAccessException} whenever an unrecoverable error occurs.
 * <b>Beware</b>: constraint violations are <b>not</b> considered unrecoverable.
 *
 * @author Jean-Michel Busca
 */
public class DataAccess {

  // To keep the emthods' interface simple, we assume there are only two
  // price classes: child and adult.
  public static final int CHILD = 1;
  public static final int ADULT = 2;

  /**
   * Creates a new <code>DataAccess</code> object that interacts with the
   * specified database, using the specified login and password. Each object
   * maintains a <b>dedicated</b> connection to the database until the
   * {@link close} method is called.
   *
   * @param url the url of the database to connect to
   * @param login the (application) login to use
   * @param password the password
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public DataAccess(String url, String login, String password) throws DataAccessException {
    // TODO
  }

  /**
   * Books the specified number of seats for the specified customer. The
   * number of seats is specified for each price class, in order to compute
   * the total amount of the booking. In addition, the customer can require
   * that the booked seats be grouped, i.e. they bear consecutive numbers. The
   * booking is performed in a all or nothing fashion.
   * <p>
   * If the booking succeeds, the method returns the same booking information
   * as a subsequent call to {@link getBookingInfo}.
   * <p>
   * The "grouped seats" criteria only applies to the current booking. The
   * method will not try to group the seats with those of a previous booking,
   * if any.
   *
   * @param customer the customer who makes the booking
   * @param childCount the number of seats to book for children
   * @param adultCount the number of seats to book for adults
   * @param groupedSeats <code>true</code> if the booked seats must be
   * grouped, and <code>false</code> otherwise
   *
   * @return a booking info object if the booking is successful, or
   * <code>null</code> if some argument is illegal or if some booking
   * criterion cannot not be satisfied
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public BookingInfo book(String customer, int childCount, int adultCount, boolean groupedSeats)
          throws DataAccessException {
    // TODO
    return null;
  }

  /**
   * Cancel, in whole or part, a previous booking made by the specified
   * customer. The cancellation specifies the number of seats to cancel in
   * each price class.
   * <p>
   * If the cancellation succeeds and some seats remain booked (partial
   * cancellation), the method returns the same booking information as a
   * subsequent call to {@link getBookingInfo}. If the cancellation succeeds
   * and all seats are cancelled (complete cancellation), the method returns
   * the following {@link BookingInfo} object: {customer, cancellation date,
   * 0.0f, empty list}.
   *
   * @param customer the customer who cancel the booking
   * @param childCount the number of child seats to cancel, -1 if all are to
   * be cancelled
   * @param adultCount the number of child seats to cancel, -1 if all are to
   * be cancelled
   *
   * @return a new booking info object if the cancellation was successful, or
   * <code>null</code> if some parameter is illegal
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public BookingInfo cancel(String customer, int childCount, int adultCount)
          throws DataAccessException {
    // TODO
    return null;
  }

  /**
   * Returns the number of all the available (free) seats. The returned
   * information is consistent with the latest booking or cancellation.
   *
   * @return the number of each of the available seats; if no seat is
   * available, the methode returns the empty list.
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public List<Integer> getAvailableSeats() throws DataAccessException {
    // TODO
    return null;
  }

  /**
   * Returns the current booking information for the specified customer. The
   * booking information reflects the overall effect of all the previous
   * bookings and cancellations the customer made. For example:
   * <li>If a customer booked 3 seats, cancelled 1 and then booked 2 more, the
   * current booking status is "4 booked seats". The returned
   * {@link BookingInfo} object bears the corresponding seat numbers, the
   * corresponding amount and the date of the latest booking or cancellation.
   * <li>If a customer never booked any seat or cancelled all the seats he/she
   * had previously booked, the method returns <code>null</code>.
   * <p>
   * If no user is specified, the method returns the booking information
   * aggregated over all the customers. The returned {@link BookingInfo}
   * object is as follows: {null, total amount, date of the latest booking or
   * cancellation, all booked seats}. If no booking was ever made, or if all
   * the bookings have been cancelled, the method returns <code>null</code>.
   *
   * @param customer the customer for whom the booking info must be returned;
   * <code>null</code> if all information must be returned
   *
   * @return the booking information for the specified customer, or for all
   * the customers if none is specified
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public BookingInfo getBookingInfo(String customer) throws DataAccessException {
    // TODO
    return null;
  }

  /**
   * Closes the underlying connection and releases all related ressources. The
   * application must call this method when it is done accessing the data
   * store.
   *
   * @throws DataAccessException if an unrecoverable error occurs
   */
  public void close() throws DataAccessException {
    // TODO
  }

}