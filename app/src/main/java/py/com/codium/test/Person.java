package py.com.codium.test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eferreira on 14/03/18.
 */

public class Person {
    @SerializedName("fname")
    public String fname;
    @SerializedName("lname")
    public String lname;
    @SerializedName("city")
    public String city;
}
