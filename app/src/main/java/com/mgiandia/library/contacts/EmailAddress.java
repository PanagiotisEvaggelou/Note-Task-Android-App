package com.mgiandia.library.contacts;

/**
 * Η διεύθυνση ηλεκτρονικού ταχυδρομείου.
 * Υλοποιείται ως αντικείμενο τιμή (value object)
 * 
 *
 */
public class EmailAddress {
    private String value;

    /**
     * Δημιουργία βάσει της συμβολοσειράς της διεύθυνσης.
     * @param email Το e-mail.
     */
    public EmailAddress(String email) {
        this.value = email;
    }

    /**
     * Επιστρέφει τη διεύθυνση ως συμβολοσειρά.
     * @return Η διεύθυνση ηλεκτρονικού ταχυδρομείου.
     */
    public String getAddress() {
        return value;
    }

    /**
     * Επαληθεύει την ορθότητα της διεύθυνσης ηλεκτρονικού ταχυδρομείου.
     * @return {@code true} εάν είναι ορθή η διεύθυνση
     * του ηλεκτρονικού ταχυδρομείου
     */
    public boolean isValid() {
        return true;
    }

    /**
     * Επαληθεύει to instance μιας διεύθυνσης ηλεκτρονικού ταχυδρομείου.
     * @param other Το άλλο αντικείμενο προς έλεγχο
     * @return Η διεύθυνσης ηλεκτρονικού ταχυδρομείου.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof EmailAddress)) {
            return false;
        }

        EmailAddress theEmail = (EmailAddress) other;
        return value == null ? theEmail.getAddress() == null
                : value.equals(theEmail.getAddress());
    }

    /**
     * Το HashCode της διεύθυνσης ηλεκτρονικού ταχυδρομείου.
     * @return Το HashCode
     */
    @Override
    public int hashCode() {
        return value == null ? 0 : value.hashCode();
    }

    /**
     * H διεύθυνση ηλεκτρονικού ταχυδρομείου με την μορφή string.
     * @return H διεύθυνση ηλεκτρονικού ταχυδρομείου
     */
    @Override
    public String toString() {
        return value;
    }
}
