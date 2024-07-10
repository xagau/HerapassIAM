package org.primefaces.rain.util;


import ai.genpen.dao.MemberDAO;
import ai.genpen.dao.OrganizationDAO;
import ai.genpen.models.Member;
import ai.genpen.models.Organization;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


/**
 * Copyright (c) 2022-2023 HeraPass.com,
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author xagau
 * @email seanbeecroft@gmail.com
 * phone 1.416.878.5282
 */


public  class Utility {

    public static String generateWalletAddress() {
        String[] publicKeys = new String[] {
                "0xee5118331df92ce3d5409eeA3fAd6cEbF3B25Ce6",
                "0xc188755061Fd3119FC381D685f8836909455F361",
                "0xaE12315dEECE4149246E41CD799D4598cFF47E03",
                "0x54Fd9B47E9fBe3652d08da2230Fed836b6e6C34C",
                "0x1FE41260AA3A31Ee10aD834046785f99dF9d35D9",
                "0xB839e2F48e36dd38f45A2bdBAc7071b2a6cEa210",
                "0x954B75597f2c838Cef71aA83D69c7ec1A7dfd369",
                "0x6e4B2AF92d773E23d8AE14Fe8F3924474e2cbe00",
                "0xeAa706574A90Da3393F824B358bC68a136ecf211",
                "0x6772e8063A8b631E6709C4c35392705829EC99Ca",
                "0xe29b064075fdc591BC7AD4d906df56A56ebfB62E",
                "0x0f62e74761DB5013A76C10f98FE30De3E886f393",
                "0x01904674C44bC1643F1b351e49008Eb604190b8A",
                "0x6F7EfbbAd2D2de0Bc7e5342823ac75DCC70fe057",
                "0xbaCe268BF510b12a3A18d811DD2b8799c2d33a0a",
                "0xd20a649244b949e572a7eF54704c2c445718d8b0",
                "0xd52ea6d4211d2AF3d2c3463b08d9C7F4Deb1B063",
                "0x5B8F72cD8363799940e8d91Dc68DCF0c68e302F8",
                "0x183905B60E9731296bF57ad0C6F71614988a3b75",
                "0x7290856402d72d87A5a0388a4e0b2a7e3d07442c",
                "0x7a18363578a52dE677122eEe341A4458F72Ca007",
                "0x1A87f46dc664C25B07725170399ad7beE7be9ce0",
                "0x79a6C62E7F4934773138b0776c21d5A376e6D29C",
                "0xB4BaB50C9C0F7a9174c59281B3717EdC54f8089f",
                "0x1C7c019B3986532cf80d71F9d4C03bC3c7A46ea8",
                "0xf5D533Fd40d361bA43952737a3d6426A4D5124ea",
                "0x60B8B92710587DF5eb0b7b87fDAAb4473eD4018E",
                "0xA9f2b14A5d379A09E9a19C2a1aF1B1d48C10B6D3",
                "0xA28b89C48E581C68c0aaf2e737C8419e4acC751b",
                "0xc9055A57350E03dcc4f3Af7B8BcE8806D1ce969E",
                "0x8eaC375367218f1aA9A740dae3A8f9847dc3fE10",
                "0xD8D76A2826e736176542dd41c05280940Ac0Ae9a",
                "0x17da0f1C70969f0D1949778EcCb880E4C3f38e03",
                "0x0150146bEf14f65BC7c9c9035baDD4326ECb3860",
                "0xf4b652C1f0a6379E3E4658D50e08AE17E69C4213",
                "0x069e7464674468f9154a9fE70A3dB46Bd56456E6",
                "0xb6AB0a743CD94fd4f7e0c0bb6DCf58042360A6b5",
                "0xB3bD88F338aEa170Bb24d0e5135Ab40d6b251c68",
                "0x693CD3B605120fA8d418904c2cBCc205EC3ba3fb",
                "0xE5fd3E855b2a55321846C9fa19b5dC1166C2958e",
                "0x24e9894513b4784b3175422610D1058Ac20c8Fa8",
                "0xf9086175200CC83e6c23Ce31D26a0caE755e9ecA",
                "0xe71AaE2d28a86F2B7586012d8d4391b5227D0Acc",
                "0xBED145a474d86BA6A17eD0b02998E39adbEd986F",
                "0xA5cc0fC7Bc646004791c6eCa13bA807db52f8aaE",
                "0xd2F2a5535453555a59d85e0b35Ee5C772c72f904",
                "0x699488E1e30B962dEA2D9B9B070f31e37192726e",
                "0xcA63EBd99dDb282fE93A93D824e118BA800313f2",
                "0x1C166e3c100861b6Dae3Ea0854Bf067d4dA5fB0c",
                "0x958948293998be7D2A042cA4626052D73D117a43",
                "0x3A6109793B1c74bB162f2f1A5b95737aC7DB27c1",
                "0xccf37C21eAf60Ff56D8b34225855988D601fd7cE",
                "0x1C5EAe28A84A39711531018c577Dc3c99BC11954",
                "0x6CBb6b93696d6A7590d340b07150dcBB0D745ec5",
                "0x42c435495e84B824BC890009abd9897B0f74B709",
                "0xBaFD639516301ba7d5B1306FEC1A33EdF6bf0f9C",
                "0x57f7ADE462Fa0C8AACEB8D0865847558e0CeAD4d",
                "0x832AF04059248d4F901d34EfE830De344A982f75",
                "0x5F4A724D844b5c1dAD92421974F18d222951a699",
                "0xaB3FF981FcF9c98e3ee905Fd2EFe2E4C2237a4ea",
                "0x136af57ea7FaD89130fd791aCAeD39cC1D7a16Fc",
                "0x84D2962aAA70986aC90B9A8A7a1a951A02c2d629",
                "0x463Df4cc683baf9C84CC5f7D0Dd6448f7C166838",
                "0xb92b9399906395748Db335a688888049F4fd1c87",
                "0x2bFA9f858F3d9e04F41f3d152b6743eDE7e68cF3",
                "0x6f9F999e197f02c92772d01a07f3192F14eC0069",
                "0xfE59815B83Ec3a982CB7515A7A2ab283b4Cde996",
                "0xf5A92933EBa15d949FcB9123699B1413771E1cd1",
                "0xaEAb790d20fB7d64CAE5c00383efdbF6E0E19437",
                "0x51Bc5334383E3a1AB7c935473439B7b7aaf7dF5d"
        };

// Printing the publicKeys array
        //for (String publicKey : publicKeys) {
        //    System.out.println(publicKey);
        //}

        int n = (int)( Math.random() * publicKeys.length );
        return publicKeys[n];
    }
    public static String getRole(String username){
        try {

            System.out.println("getRole called with::" + username);
            MemberDAO memberDAO = new MemberDAO();
            Member m = memberDAO.findByMemberName(username);
            if( username == null ){
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: null");
                return "unknown";
            }
            else if (m != null) {
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: member");
                return "member";
            } else {
                System.out.println("No member named:" + username + " was found when looked up by field member_name");
            }

            OrganizationDAO organizationDAO = new OrganizationDAO();
            Organization o = organizationDAO.findByContact(username);

            if (o != null) {
                System.out.println("getRole called (inside) Utility.getRole():::" + username + " role: organization");
                return "organization";
            } else {
                System.out.println("No org named:" + username + " was found when looked up by field findByContact");
            }
            if (username != null && !username.isEmpty() && username.equalsIgnoreCase("sean@genpen.ai")) {
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: admin");
                return "admin";
            } else {
                System.out.println("No admin named:" + username + " was found when looked up ");

            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("getRole called (inside) Utility.getRole():" + username + " role: unknown");

        boolean f = true;

        if( f ) {
            if (username != null && username.equalsIgnoreCase("sean@genpen.ai")) {
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: fall back admin ");
                return "admin";
            }
            if (username != null && username.equalsIgnoreCase("logan@genpen.ai")) {
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: fall back member ");
                return "member";
            }
            if (username != null && username.equalsIgnoreCase(Globals.defaultUser)) {
                System.out.println("getRole called (inside) Utility.getRole():" + username + " role: fall back organization ");
                return "organization";
            }
        }
        return "unknown";
    }

    static final String AAB = "23456789ABCDFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrztuvwxyz";

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnlopqrztuvwxyz";
    static final String NAB = "0123456789";
    public static File lf = null;
    static Random rnd = new Random();

    /*
    public static String numberToEnglish(String number) {
        try {
            Integer integer = Integer.parseInt(number);
            return numberToEnglish(integer.intValue());
        } catch (Exception e) {
            return number;
        }
    }

     */

    public static String numberToEnglish(int number) {
        if (number == 0) {
            return "zero";
        }
        if (number < 0) {
            return "minus " + Utility.numberToEnglish(Math.abs(number));
        }

        String words = "";
        String[] unitsArray = {"", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensArray = {"", "", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};

        if (number < 20) {
            words = unitsArray[number];
        } else if (number < 100) {
            words = tensArray[number / 10] + " " + unitsArray[number % 10];
        } else if (number < 1000) {
            words = unitsArray[number / 100] + " hundred ";
            if (number % 100 != 0) {
                words += "and " + numberToEnglish(number % 100);
            }
        } else if (number < 1000000) {
            words = numberToEnglish(number / 1000) + " thousand ";
            if (number % 1000 != 0) {
                words += numberToEnglish(number % 1000);
            }
        } else if (number < 1000000000) {
            words = numberToEnglish(number / 1000000) + " million ";
            if (number % 1000000 != 0) {
                words += numberToEnglish(number % 1000000);
            }
        } else {
            words = "Number is too large to be represented in English";
        }

        return words.trim();
    }

    public static boolean isAcceptableAttributeName(String name) {
        if (name == null || name.isEmpty() || name.equalsIgnoreCase("null") || name.equalsIgnoreCase("date")) {
            return false;
        } else if (name.toLowerCase(Locale.ROOT).startsWith("gpo")) {
            return false;
        } else if (name.toLowerCase(Locale.ROOT).endsWith("_fk")) {
            return false;
        }
        char c = name.charAt(0);
        if (isNumber("" + c)) {
            return false;
        }
        return true;
    }

    public static boolean isWorkflowType(String type) {
        if (type.equalsIgnoreCase("Workflow") || type.equalsIgnoreCase("Rule") || type.equalsIgnoreCase("Element")) {
            return true;
        }
        return false;
    }

    // TODO Refactor
    public static String getGenPenType(File file) {
        String abs = file.getAbsolutePath();
        abs = abs.toLowerCase(Locale.ROOT);
        String type = "";
        if (abs.endsWith("/models") && file.isDirectory()) {
            type = "ModelExplorer";
        } else if (abs.endsWith("/workflows") && file.isDirectory()) {
            type = "WorkflowExplorer";
        } else if (abs.contains("/models/") && file.isDirectory()) {
            type = "Model";
        } else if (abs.contains("/workflows/") && file.isDirectory()) {
            type = "Workflow";
        } else if (abs.contains("/models/") && file.isFile()) {
            type = "Attribute";
        } else if (abs.contains("/workflows/") && file.isFile() && abs.endsWith("element")) {
            type = "Element";
        } else if (abs.contains("/workflows/") && file.isFile() && abs.endsWith("properties")) {
            type = "Properties";
        } else if (abs.contains("/workflows/") && file.isFile() && abs.endsWith("rule")) {
            type = "Rule";
        } else {
            type = "Non-type";
        }
        return type;
    }

    public static boolean isRule(File file) {
        if (file.getAbsolutePath().endsWith("rule")) {
            return true;
        }
        return false;
    }

    public static String createCompatibleModelName(String model) {
        System.out.println("before test [" + model + "]");
        model = model.replaceAll("   ", " ");
        model = model.replaceAll("  ", " ");
        model = model.replaceAll("&", " and ");
        model = model.replaceAll("\\\\", " or ");
        model = model.replaceAll("/", " or ");
        model = model.replaceAll("\\[", "");
        model = removeSpecialCharactersExceptUnderscoreAndSpace(model);
        model = model.trim();
        if (model.endsWith(" or") || model.endsWith(" and")) {
            model = model.replaceAll("(\\s+(or|and))+$", "");
        }
        model = convertAllNumbersToEnglish(model);
        model = convertCaseToTitleCase(model);
        model = model.trim();
        Pair p = countWords(model);
        model = p.getName(); // Store information in a hashmap for later use.
        System.out.println("after test [" + model + "]");
        return model;
    }

    /*
    private static String convertAllNumbersToEnglish(String model) {
        String[] split = model.split(" ");
        StringBuilder out = new StringBuilder();
        for (String s : split) {
            if (isNumber(s)) {
                out.append(" ").append(numberToEnglish(s));
            } else {
                out.append(" ").append(s);
            }
        }
        return out.toString();
    }

     */

    public static boolean isPrimitiveType(String type) {
        if (type == null || type.isEmpty()) {
            return false;
        }
        if (type.equalsIgnoreCase("string")) {
            return true;
        } else if (type.equalsIgnoreCase("long")) {
            return true;
        } else if (type.equalsIgnoreCase("short")) {
            return true;
        } else if (type.equalsIgnoreCase("integer")) {
            return true;
        } else if (type.equalsIgnoreCase("date")) {
            return true;
        } else if (type.equalsIgnoreCase("boolean")) {
            return true;
        } else if (type.equalsIgnoreCase("byte")) {
            return true;
        } else if (type.equalsIgnoreCase("double")) {
            return true;
        } else if (type.equalsIgnoreCase("float")) {
            return true;
        }


        return false;
    }

    public static int randomInteger(int max) {
        return (int) (Math.random() * max);
    }


    public static boolean isNumber(String str) {
        // Remove any leading or trailing whitespace
        str = str.trim();

        try {
            // Try to parse the string as a double
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            // The string is not a number
            return false;
        }
    }

    public static String numberToEnglish(String number) {
        try {
            Integer integer = Integer.parseInt(number);
            return numberToEnglish(integer);
        } catch (Exception e) {
            return number;
        }
    }

    public static String getSuperClassSimpleName(Class<?> c) {
        Class<?> parentClass = c.getSuperclass();
        return parentClass.getSimpleName();
    }

    public static void sleep(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // Generate a random character between 'A' and 'Z', inclusive
            char c = (char) ('A' + random.nextInt(26));

            // If this is the first character, ensure it is either an underscore or an alphabet character
            if (i == 0) {
                while (c != '_' && !Character.isAlphabetic(c)) {
                    c = (char) ('A' + random.nextInt(26));
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }

    /*
    public String getSwaggerTypeName(){
        if( type == null ){
            throw new IllegalArgumentException("DataType cannot be null to convert to swagger type name");
        }
        switch(type){
            case BYTE:
                return "byte";
            case LONG:
                return "long";
            case FLOAT:
                return "float";
            case STRING:
                return "string";
            case DOUBLE:
                return "double";
            case BOOLEAN:
                return "boolean";
            case INTEGER:
                return "int32";
            case NULL:
                return "null"; // check all
            case CHARACTER:
                return "char";
            case BIG_DECIMAL:
                return "decimal";
            case DATE:
                return "date";
        }
        return "unknown";
    }
     */

    public static String convertUpperCaseToHuman(String name) {
        char[] words = name.toCharArray();
        String sentence = "";
        for (int i = 0; i < words.length; i++) {
            char t = words[i];
            String u = String.valueOf(words[i]);
            u = u.toUpperCase();
            char ut = u.charAt(0);
            if (t == ut) {
                sentence = sentence + " " + ut;
            } else {
                sentence += t;
            }
        }
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        sentence = sentence.trim();
        sentence = sentence.toLowerCase();
        sentence = capitalize(sentence);
        return sentence;
    }

    public static String convertLowerCaseToHuman(String name) {

        return convertUpperCaseToHuman(name);
    }


    public static int lineCount(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int lc = text.split("\n").length;
        return lc;
    }



    public static String readFileToString(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    public static ArrayList<String> getAllFilePaths(File root) {

        System.out.println("getAllFilePaths called");
        System.out.println(root.getAbsolutePath());

        ArrayList<String> arrayList = new ArrayList<>();

        File[] allContents = root.listFiles();
        if (allContents != null) {
            for (File f : allContents) {
                if (f.isDirectory()) {
                    arrayList.addAll(getAllFilePaths(f));
                } else {
                    String lc = f.getAbsolutePath();
                    System.out.println("Add lc:" + lc);
                    arrayList.add(lc);
                }
            }
        }
        return arrayList;
    }

    public static String loadDefaultBase() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Globals.RESOURCE_HOME + "/templates/schema-base.fragment"))));
            String buf = null;
            String contents = "";
            while ((buf = reader.readLine()) != null) {
                contents += buf + "\n";
            }
            return contents;
        } catch (Exception ex) {
            return "";
        }

    }

    public static String createFilePath(TreePath treePath) {
        StringBuilder sb = new StringBuilder();
        Object[] nodes = treePath.getPath();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(File.separatorChar).append(nodes[i].toString());
        }
        return sb.toString();
    }

    public static String loadCode(File file) {
        try {

            if (file == null) {
                System.out.println("file == null ");
                if (lf != null) {
                    file = lf;
                    System.out.println("lf was not null, assign to lf");
                } else {
                    return "";
                }
            }

            if (file.isFile()) {
                lf = file;
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String buf = null;
                StringBuilder contents = new StringBuilder();
                while ((buf = reader.readLine()) != null) {
                    contents.append(buf).append("\n");
                }
                return contents.toString();
            } else {
                System.out.println("It is a directory");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
        System.out.println("Exit of Utility.loadCode() return empty string");
        return "";
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String lowerize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String readFileAsString(File fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName.getAbsolutePath())));
        return data;
    }

    public static String loadDefaultPathBase(String name) {
        try {
            File scpf = new File(Globals.RESOURCE_HOME + "/templates/schema-component-path.fragment");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(scpf)));
            String buf = null;
            String contents = "";
            while ((buf = reader.readLine()) != null) {
                contents += buf + "\n";
            }


            String lowerName = Utility.convertPresentableToLowerCamelCase(name);
            String upperName = Utility.convertPresentableToUpperCamelCase(name);
            String lowerAllName = lowerName.toLowerCase();
            String humanName = Utility.convertUpperCaseToHuman(upperName);

            contents = contents.replaceAll("__ModelTypeUpper__", upperName);
            contents = contents.replaceAll("__ModelTypeLower__", lowerName);
            contents = contents.replaceAll("__ModelTypeAllLower__", lowerAllName);
            contents = contents.replaceAll("__UpperCaseToHumanSentence__", humanName);
            contents = contents.replaceAll("__LowerCaseToHumanSentence__", humanName);

            return contents;
        } catch (Exception ex) {
            return "";
        }
    }

    public static String loadDefaultComponents() {
        try {
            File sf = new File(Globals.RESOURCE_HOME + "/templates/schema-components.fragment");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sf)));
            String buf = null;
            String contents = "";
            while ((buf = reader.readLine()) != null) {
                contents += buf + "\n";
            }
            return contents;
        } catch (Exception ex) {
            return "";
        }

    }

    public static String convertPresentableToEnumType(String in) {
        in = in.toUpperCase();
        in = in.replaceAll(" ", "_");
        return in;
    }

    public static String convertCanonicalNameToFriendly(String n) {
        String out = n;
        String[] initialPart = out.split(" ");
        return out;
    }

    public static String getValue(Object o, String val) {
        if (o == null) {
            return "null";
        } else if (o instanceof Long) {
            Long lng = (Long) o;
            return String.valueOf(Long.valueOf(val));
        } else if (o instanceof String) {
            String str = (String) o;
            return str;
        } else if (o instanceof Boolean) {
            Boolean b = (Boolean) o;
            return String.valueOf(Boolean.valueOf(val));
        } else if (o instanceof Integer) {
            Integer i = (Integer) o;
            return String.valueOf(Integer.valueOf(val));
        } else if (o instanceof BigDecimal) {
            BigDecimal bg = (BigDecimal) o;
            return String.valueOf(new BigDecimal(val));
        } else if (o instanceof Character) {
            Character c = (Character) o;
            return String.valueOf(Character.valueOf(val.charAt(0)));
        } else if (o instanceof Byte) {
            Byte b = (Byte) o;
            return String.valueOf(Byte.valueOf(val));
        } else if (o instanceof Short) {
            Short b = (Short) o;
            return String.valueOf(Short.valueOf(val));
        } else if (o instanceof Double) {
            Double d = (Double) o;
            return String.valueOf(Double.valueOf(val));
        } else if (o instanceof Float) {
            Float f = (Float) o;
            return String.valueOf(Float.valueOf(val));
        } else if (o instanceof ArrayList) {
            ArrayList a = (ArrayList) o;
            return String.valueOf(a.toArray().toString());
        }
            /* else if (o instanceof RulesType) {
                return Utility.convertPresentableToEnumType(o.toString());

            } else if (o instanceof ElementType) {
                return Utility.convertPresentableToEnumType(o.toString());

            } else if (o instanceof Object) {
                return String.valueOf(o);
            }
             */
        else {
            return "unknown";
        }

    }

    public static String convertEnumTypeToPresentable(String v) {
        if (v == null || v.equals("")) {
            return "";
        }
        v = v.replaceAll("_", " ");
        v = v.toLowerCase();
        String[] split = v.split(" ");
        String out = "";

        for (int i = 0; i < split.length; i++) {
            String sp = split[i];
            String c = sp.charAt(0) + "";
            String ch = c.toUpperCase();
            sp = sp.replaceFirst(c, ch);
            out += sp + " ";
        }
        out = out.trim();
        return out;
    }

    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    public static String convertCamelCaseToUpperSnakeCase(String in) {
        if (in == null || in.equals("")) {
            return "";
        }
        String out = in;
        out = convertUpperCaseToHuman(out);
        out = out.replaceAll(" ", "_");
        out = out.replaceAll("__", "_");
        out = out.toUpperCase();
        return out;
    }

    public static String convertCamelCaseToLowerSnakeCase(String in) {
        if (in == null || in.equals("")) {
            return "";
        }
        in = convertCamelCaseToUpperSnakeCase(in);
        in = in.toLowerCase();
        return in;
    }

    public static String convertHumanSentenceToLowerSnakeCase(String in) {
        if (in == null || in.equals("")) {
            return "";
        }
        String out = in;
        out = out.trim();
        out = out.replaceAll("\\.", "");
        out = out.replaceAll("   ", "_");
        out = out.replaceAll("  ", "_");
        out = out.replaceAll(" ", "_");
        out = out.toLowerCase();
        return out;
    }

    public static String convertLowerSnakeCaseToDashCase(String in) {
        if (in == null || in.equals("")) {
            return "";
        }
        String out = in;
        out = out.trim();
        out = out.replaceAll("\\.", "");
        out = out.replaceAll("_", "-");
        out = out.toLowerCase();
        return out;
    }

    public static String convertHumanSentenceToUpperSnakeCase(String in) {
        if (in == null || in.equals("")) {
            return "";
        }
        String out = in;
        out = convertHumanSentenceToLowerSnakeCase(out);
        out = out.toUpperCase();
        return out;
    }

    public static String convertSplitCamelCaseToEnumTypeInput(String v) {
        if (v == null || v.equals("")) {
            return "";
        }
        String out = v;
        out = out.replaceAll(" ", "_");
        out = out.toUpperCase();
        return out;

    }

    public static void main(String[] args) {

        System.out.println(Utility.hashString("password"));

        System.out.println(Utility.createCompatibleModelName("This is a crappy Model"));
        System.out.println(Utility.createCompatibleModelName("Strong Model"));
        System.out.println(Utility.createCompatibleModelName("Strong Model 1."));
        System.out.println(Utility.createCompatibleModelName("Strong Model 1="));
        System.out.println(Utility.createCompatibleModelName("Strong Model 1/"));
        System.out.println(Utility.createCompatibleModelName("strong model 1345\\"));

        /*
        System.out.println(convertHumanSentenceToUpperSnakeCase("Upper Case Api Object"));
        System.out.println(convertHumanSentenceToLowerSnakeCase("Upper Case Api Object"));

        RulesType rt = RulesType.NOTHING_REQUIRED_CONTINUE;
        String s = Utility.convertEnumTypeToPresentable(rt.name());
        System.out.println(s);

        s = Utility.convertPresentableToUpperCamelCase(s);
        System.out.println(s);
        s = Utility.convertUpperCamelCaseToLowerCamelCase(s);
        System.out.println(s);
        s = Utility.convertLowerCamelCaseToUpperCamelCase(s);
        System.out.println(s);
        System.out.println(s = Utility.convertUpperCaseToHuman(s));
        System.out.println(s = Utility.convertHumanSentenceToLowerSnakeCase(s));
        System.out.println(s = Utility.convertPresentableToEnumType(s));

        System.out.println(convertUpperCaseToHuman("UpperCaseApiObject"));
        System.out.println(convertLowerCaseToHuman("lowerCaseApiObject"));
        System.out.println(convertPresentableToLowerCamelCase("human head"));
        System.out.println(convertPresentableToUpperCamelCase("human head"));
        System.out.println(convertEnumTypeToPresentable(ElementType.BLOCK_HEIGHT_AT_END_OF_PROCESS.toString()));
        System.out.println(convertSplitCamelCaseToEnumTypeInput(convertEnumTypeToPresentable(ElementType.BLOCK_HEIGHT_AT_END_OF_PROCESS.toString())));
        */
    }

    private static String convertUpperCamelCaseToLowerCamelCase(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        s = s.replaceAll(" ", "");
        char fl = s.charAt(0);
        String sfl = "" + fl;
        sfl = sfl.toLowerCase();
        char[] words = s.toCharArray();
        words[0] = sfl.charAt(0);
        String str = String.valueOf(words);
        return str;
    }

    private static String convertLowerCamelCaseToUpperCamelCase(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        s = s.replaceAll(" ", "");
        char fl = s.charAt(0);
        String sfl = "" + fl;
        sfl = sfl.toUpperCase();
        char[] words = s.toCharArray();
        words[0] = sfl.charAt(0);
        String str = String.valueOf(words);
        return str;
    }

    public static String convertCaseToTitleCase(String name) {
        name = name.toLowerCase();
        String out = "";
        boolean first = true;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c != ' ') {
                if (first) {
                    String cc = "" + c;
                    cc = cc.toUpperCase();
                    out += cc;
                    first = false;
                } else {
                    out += c;
                }
            } else {
                out += ' ';
                first = true;
            }
        }
        return out;
    }

    public static String convertPresentableToUpperCamelCase(String name) {
        name = name.toLowerCase();
        String out = "";
        boolean first = true;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c != ' ') {
                if (first) {
                    String cc = "" + c;
                    cc = cc.toUpperCase();
                    out += cc;
                    first = false;
                } else {
                    out += c;
                }
            } else {
                first = true;
            }
        }
        return out;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isEven(int n) {
        return !isOdd(n);
    }

    public static String convertPresentableToLowerCamelCase(String name) {

        String out = "";
        boolean first = true;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c != ' ') {
                if (first) {
                    String cc = "" + c;
                    cc = cc.toLowerCase();
                    out += cc;
                    first = false;
                } else {
                    out += c;
                }
            } else {
                first = true;
                try {
                    String cc = "" + name.charAt(i + 1);
                    cc = cc.toUpperCase();
                    out += cc;
                    i++;
                } catch (Exception ex) {
                }
            }
        }
        return out;
    }

    public static String toLowerCamelCase(String name) {
        String out = "";
        boolean first = true;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (first) {
                String cc = "" + c;
                cc = cc.toLowerCase();
                out += cc;
                first = false;
            } else {
                out += c;
                try {
                    String cc = "" + name.charAt(i + 1);
                    out += cc;
                    i++;
                } catch (Exception ex) {
                }
            }
        }
        return out;
    }

    public static String convertUpperCaseLowerCamelCase(String upperCaseName) {
        if (upperCaseName == null || upperCaseName.isEmpty()) {
            return "";
        }

        String lower = lowerize(upperCaseName);
        return lower;
    }

    public static String convertUpperCaseToLowerCamelCase(String upperCaseName) {
        if (upperCaseName == null || upperCaseName.isEmpty()) {
            return "";
        }

        String lower = lowerize(upperCaseName);
        return lower;
    }

    public static String convertLowerCamelCaseToUpperCaseCamel(String lowerCaseName) {
        if (lowerCaseName == null || lowerCaseName.isEmpty()) {
            return "";
        }

        String lower = capitalize(lowerCaseName);
        return lower;
    }

    public static String convertUpperCaseToLowerSnakeCase(String upperCaseName) {
        if (upperCaseName == null || upperCaseName.isEmpty()) {
            return "";
        }

        String lower = Utility.convertCamelCaseToLowerSnakeCase(upperCaseName);
        return lower;
    }

    public static String getAccessorPrefix(String type) {

        if (type.equalsIgnoreCase("Boolean")) {
            return "is";
        } else {
            return "get";
        }
    }

    public static File[] countDirectories(File directory) {
        // Create a list to store the files
        List<File> files = new ArrayList<>();

        // Get a list of all the files in the directory
        File[] children = directory.listFiles();

        // Iterate through the list of files
        for (File child : children) {
            // If the file is a directory, recursively count the files in the directory
            if (child.isDirectory()) {
                File[] subfiles = countDirectories(child);
                files.add(child);
                for (int i = 0; i < subfiles.length; i++) {
                    File f = subfiles[i];
                    if (f.isDirectory()) {
                        files.add(f);
                    }
                }
            }

        }

        // Convert the list to an array and return it
        File[] arr = new File[files.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = files.get(i);
        }
        return arr;
    }

    public static String getDefaultValueForPrimitive(String type) {

        if (type.equalsIgnoreCase("String")) {
            return " \"\"";
        } else if (type.equalsIgnoreCase("Object")) {
            return " null";
        } else if (type.equalsIgnoreCase("Integer")) {
            return " 0";
        } else if (type.equalsIgnoreCase("Boolean")) {
            return " false";
        } else if (type.equalsIgnoreCase("Long")) {
            return " 0L";
        } else if (type.equalsIgnoreCase("Float")) {
            return " 0f";
        } else if (type.equalsIgnoreCase("Double")) {
            return " 0.0";
        } else if (type.equalsIgnoreCase("Date")) {
            return " new Date(System.currentTimeMillis())";
        } else {
            return "0";
        }
    }

    public static void writeFile(String buf, String filePath) {
        System.out.println("utility file path:" + filePath);
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            BufferedReader reader = new BufferedReader(new StringReader(buf));
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void appendToFile(String buf, boolean endLine, String filePath) {
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            if (endLine) {
                writer.append(buf).append("\n");
            } else {
                writer.append(buf);
            }
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void appendToFile(String buf, String filePath) {
        appendToFile(buf, true, filePath);
    }

    public static StringBuffer readFile(String filePath, boolean print) {
        StringBuffer buffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Do something with the line
                buffer.append(line).append("\n");
                if (print) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void readFile(String filePath) {
        readFile(filePath, true);
    }

    public static String getDefaultSwaggerValueForPrimitive(String type) {

        if (type.equalsIgnoreCase("String")) {
            return "";
        } else if (type.equalsIgnoreCase("Object")) {
            return "null";
        } else if (type.equalsIgnoreCase("Boolean")) {
            return "false";
        } else if (type.equalsIgnoreCase("Long")) {
            return "0L";
        } else if (type.equalsIgnoreCase("Float")) {
            return "0f";
        } else if (type.equalsIgnoreCase("Double")) {
            return "0.0";
        } else if (type.equalsIgnoreCase("Date")) {
            return "01-01-1968";
        } else {
            return "0";
        }
    }

    public static Pair countWords(String sentence) {
        Pair pair = new Pair();
        String[] words = sentence.split("\\s+");
        if (words.length > 3) {
            StringBuilder sb = new StringBuilder();
            for (int i = 3; i < words.length; i++) {
                sb.append(words[i]).append(" ");
            }
            String information = sb.toString().trim();
            String name = words[0] + " " + words[1] + " " + words[2];
            pair = new Pair(name, information);
        } else {
            pair.setName(sentence);
        }
        return pair;
    }

    public static boolean isLanguage(String language) {
        if (Globals.language.toLowerCase().equalsIgnoreCase(language)) {
            return true;
        } else if ((Globals.language.equalsIgnoreCase("jaxrs-spec") || Globals.language.equalsIgnoreCase("jaxrs"))) {
            return language.equalsIgnoreCase("java");
        }
        return false;
    }

    public static String languageByExtension(File file) {
        if (file == null) {
            return null;
        }
        String abp = file.getAbsolutePath();
        String labp = abp.toLowerCase();
        if (labp.endsWith("dockerfile")) {
            return "dockerfile";
        }
        if (labp.endsWith("makefile")) {
            return "makefile";
        }

        String ext = abp.substring(abp.lastIndexOf(".") + 1, abp.length());

        if (ext.isEmpty()) {
            return null;
        }

        if (ext.equalsIgnoreCase("py")) {
            return "python";
        } else if (ext.equalsIgnoreCase("bat")) {
            return "bat";
        } else if (ext.equalsIgnoreCase("rs")) {
            return "rust";
        } else if (ext.equalsIgnoreCase("sh")) {
            return "bash";
        } else if (ext.equalsIgnoreCase("asm")) {
            return "assembler";
        } else if (ext.equalsIgnoreCase("cpp")) {
            return "c++";
        } else if (ext.equalsIgnoreCase("c")) {
            return "c";
        } else if (ext.equalsIgnoreCase("h")) {
            return "c";
        } else if (ext.equalsIgnoreCase("md")) {
            return "markdown";
        } else if (ext.equalsIgnoreCase("java")) {
            return "java";
        } else if (ext.equalsIgnoreCase("js")) {
            return "javascript";
        } else if (ext.equalsIgnoreCase("ts")) {
            return "typescript";
        } else if (ext.equalsIgnoreCase("clj")) {
            return "clojure";
        } else if (ext.equalsIgnoreCase("rb")) {
            return "ruby";
        } else if (ext.equalsIgnoreCase("adb")) {
            return "ada";
        } else if (ext.equalsIgnoreCase("ads")) {
            return "ada";
        } else if (ext.equalsIgnoreCase("grp")) {
            return "ada";
        } else if (ext.equalsIgnoreCase("json")) {
            return "json";
        } else if (ext.equalsIgnoreCase("xml")) {
            return "xml";
        } else if (ext.equalsIgnoreCase("lua")) {
            return "lua";
        } else if (ext.equalsIgnoreCase("go")) {
            return "go";
        } else if (ext.equalsIgnoreCase("hs")) {
            return "haskell";
        } else if (ext.equalsIgnoreCase("yaml")) {
            return "yaml";
        } else if (ext.equalsIgnoreCase("yml")) {
            return "yaml";
        } else if (ext.equalsIgnoreCase("html")) {
            return "html";
        } else if (ext.equalsIgnoreCase("htm")) {
            return "html";
        } else if (ext.equalsIgnoreCase("css")) {
            return "css";
        } else if (ext.equalsIgnoreCase("gl")) {
            return "opengl";
        } else if (ext.equalsIgnoreCase("sql")) {
            return "sql";
        } else if (ext.equalsIgnoreCase("kt")) {
            return "kotlin";
        } else if (ext.equalsIgnoreCase("groovy")) {
            return "groovy";
        } else if (ext.equalsIgnoreCase("php")) {
            return "php";
        } else if (ext.equalsIgnoreCase("r")) {
            return "r";
        } else if (ext.equalsIgnoreCase("sc")) {
            return "scala";
        } else if (ext.equalsIgnoreCase("bas")) {
            return "basic";
        } else if (ext.equalsIgnoreCase("cs")) {
            return "csharp";
        } else if (ext.equalsIgnoreCase("g")) {
            return "little-g";
        } else if (ext.equalsIgnoreCase("vasm")) {
            return "virtual assembler";
        } else if (ext.equalsIgnoreCase("hpp")) {
            return "c++";
        } else if (ext.equalsIgnoreCase("ini")) {
            return "ini";
        }
        return "text";
    }

    public static String removeSpecialCharactersExceptUnderscoreAndSpace(String str) {
        return str.replaceAll("[^\\w\\s_]|(?<!\\S)_", "").replaceAll("\\s{2,}", " ");
    }

    public static String removeSpecialCharacters(String str) {
        return str.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static String convertAllNumbersToEnglish(String model) {
        String[] split = model.split(" ");
        StringBuilder out = new StringBuilder();
        for (String s : split) {
            if (isNumber(s)) {
                out.append(" ").append(numberToEnglish(s));
            } else {
                out.append(" ").append(s);
            }
        }
        return out.toString();
    }

    public static String loadExtension(File file) {
        if (file == null) {
            return null;
        } else if (!file.exists()) {
            return null;
        } else if (file.isDirectory()) {
            return null;
        }

        String str = file.getAbsolutePath();
        int index = str.lastIndexOf(".");
        String ext = str.substring(index + 1, str.length());
        if (ext.isEmpty()) {
            return null;
        } else {
            return ext;
        }
    }

    /**
     * Guess whether given file is binary. Just checks for anything under 0x09.
     */
    public static boolean isBinaryFile(File f) throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream(f);
        int size = in.available();
        if (size > 1024) size = 1024;
        byte[] data = new byte[size];
        in.read(data);
        in.close();

        int ascii = 0;
        int other = 0;

        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            if (b < 0x09) return true;

            if (b == 0x09 || b == 0x0A || b == 0x0C || b == 0x0D) ascii++;
            else if (b >= 0x20 && b <= 0x7E) ascii++;
            else other++;
        }

        if (other == 0) return false;

        return 100 * other / (ascii + other) > 95;
    }

    public static String shortId() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String split[] = str.split("-");
        str = split[4];
        System.out.println(str.substring(0, 3));
        return str.substring(0, 3);
    }

    public static void copyFolder(Path src, Path dest) throws IOException {
        try (Stream<Path> stream = Files.walk(src)) {
            stream.forEach(source -> copy(source, dest.resolve(src.relativize(source))));
        }
    }

    private static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static ArrayList<String> getExpandedMatchingNodes(JTree tree, DefaultMutableTreeNode node) {
        ArrayList<String> expandedNodeValues = new ArrayList<>();

        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            TreePath path = new TreePath(child.getPath());
            if (tree.isExpanded(path)) {
                expandedNodeValues.add((String) child.getUserObject());
                expandedNodeValues.addAll(getExpandedMatchingNodes(tree, (DefaultMutableTreeNode) child));
            }
        }
        return expandedNodeValues;
    }

    public static void copyFile(File src, File dst) {
        try {
            StandardCopyOption op = StandardCopyOption.REPLACE_EXISTING;
            Files.copy(src.toPath(), dst.toPath(), op);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String createCompatibleAttributeName(String ba) {
        ba = ba.trim();
        System.out.println("before test [" + ba + "]");
        ba = ba.replaceAll("   ", " ");
        ba = ba.replaceAll("  ", " ");
        ba = ba.replaceAll("&", " and ");
        ba = ba.replaceAll("\\\\", " or ");
        ba = ba.replaceAll("/", " or ");
        ba = removeSpecialCharactersExceptUnderscoreAndSpace(ba);
        ba = ba.trim();
        if (ba.endsWith(" or") || ba.endsWith(" and")) {
            ba = ba.replaceAll("(\\s+(or|and))+$", "");
        }
        //ba = Utility.convertAllNumbersToEnglish(ba);
        //ba = Utility.convertCaseToTitleCase(ba);
        ba = ba.trim();
        Pair p = countWords(ba);
        ba = p.getName(); // Store information in a hashmap for later use.
        System.out.println("after test [" + ba + "]");
        return ba;
    }

    public static String removeNumbers(String str) {
        return str.replaceAll("\\d+", "");
    }

    public static boolean isPrimitiveAttributeType(String type) {
        ArrayList<String> types = new ArrayList<>();
        types.add("boolean");
        types.add("integer");
        types.add("long");
        types.add("date");
        types.add("string");
        types.add("double");
        types.add("float");
        types.add("short");
        types.add("byte");
        return types.contains(type);
    }


    /////////////////////////////////////////////////

    public static String createCompatibleAttributeType(String type) {


        System.out.println("before attribute type:" + type);

        type = type.trim();
        type = removeSpecialCharacters(type);

        type = type.toLowerCase(Locale.ROOT);
        type = removeNumbers(type);
        String[] toks = type.split(" ");
        type = toks[0];
        System.out.println("after attribute type:" + type);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (type.equalsIgnoreCase("int")) {
            return "integer";
        }

        return type;

    }

    public static void delete(Path path) throws Exception {
        if (Files.isDirectory(path)) {
            // If the path is a directory, iterate over its contents and delete them
            Files.list(path).forEach(child -> {
                try {
                    delete(child);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        // Delete the file or empty directory
        Files.deleteIfExists(path);
    }

    public static String getData(String urlString) {
        String userAgent = "HeraPass.com User Agent version " + Globals.major + "." + Globals.minor;
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpsURLConnection connection = null;
        try {
            connection = (HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setRequestProperty("User-Agent", userAgent);

        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Response code: " + responseCode);

        // Read the response from the server
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        StringBuilder response = new StringBuilder();
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.append(line);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the response from the server
        System.out.println("Response: " + response.toString());
        return response.toString();
    }

    public static void closeQuietly(Connection conn, Statement statement, ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (Exception ex) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception ex) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
            }
        }

        conn = null;
        statement = null;
        result = null;

        System.gc();

    }

    public static void closeQuietly(Connection conn, PreparedStatement statement, ResultSet result) {
        if (result != null) {
            try {
                result.close();
                result = null;
            } catch (Exception ex) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (Exception ex) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (Exception ex) {
            }
        }
        conn = null;
        statement = null;
        result = null;

        System.gc();

    }

    public static String redact(String str) {
        char[] c = str.toCharArray();
        String ret = "";
        for (int i = 0; i < c.length; i++) {
            if (i == 0) {
                ret += c[i];
            } else if (i + 1 == c.length) {
                ret += c[i];
            } else {
                ret += "*";
            }
        }
        return ret;
    }

    public static String getBrowserInfo(HttpServletRequest request) {

        return getBrowserInfo(request.getHeader("User-Agent"));

    }

    public static boolean closeQuietly(Statement statement, Connection connection, ResultSet r) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                statement = null;
            }
            if (r != null && !r.isClosed()) {
                r.close();
                r = null;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean closeQuietly(PreparedStatement statement, Connection connection, ResultSet r) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                statement = null;
            }
            if (r != null && !r.isClosed()) {
                r.close();
                r = null;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String getBrowserInfo(String Information) {
        String browsername = "";
        String browserversion = "";
        String browser = Information;
        if (browser.contains("MSIE")) {
            String subsString = browser.substring(browser.indexOf("MSIE"));
            String info[] = (subsString.split(";")[0]).split(" ");
            browsername = info[0];
            browserversion = info[1];
        } else if (browser.contains("Firefox")) {

            String subsString = browser.substring(browser.indexOf("Firefox"));
            String info[] = (subsString.split(" ")[0]).split("/");
            browsername = info[0];
            browserversion = info[1];
        } else if (browser.contains("Chrome")) {

            String subsString = browser.substring(browser.indexOf("Chrome"));
            String info[] = (subsString.split(" ")[0]).split("/");
            browsername = info[0];
            browserversion = info[1];
        } else if (browser.contains("Opera")) {

            String subsString = browser.substring(browser.indexOf("Opera"));
            String info[] = (subsString.split(" ")[0]).split("/");
            browsername = info[0];
            browserversion = info[1];
        } else if (browser.contains("Safari")) {

            String subsString = browser.substring(browser.indexOf("Safari"));
            String info[] = (subsString.split(" ")[0]).split("/");
            browsername = info[0];
            browserversion = info[1];
        }
        return browsername + "-" + browserversion;
    }

    public static String getDevice(HttpServletRequest request) {
        return getDevice(request.getHeader("User-Agent"));
    }

    public static String getCountry(HttpServletRequest request) {
        return request.getLocale().getCountry();
    }

    public static String getDevice(String info) {
        int condition = 0;
        info = info.toLowerCase();
        if (info.contains("android")) {
            condition = 0;
        } else if (info.contains("iphone")) {
            condition = 1;
        } else if (info.contains("ipad")) {
            condition = 2;
        } else if (info.contains("tablet")) {
            condition = 3;
        } else if (info.contains("tv")) {
            condition = 5;
        } else {
            condition = 4;
        }

        switch (condition) {
            case 0:
                return "Android";
            case 1:
                return "iPhone";
            case 2:
                return "iPad";
            case 3:
                return "Tablet";
            case 4:
                return "Desktop";
            case 5:
                return "TV";
        }
        return "Desktop";
    }

    public static String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (password.length() > 21) {
            return false;
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            return false;
        }
        if (password.matches("[a-zA-Z]*99")) {
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        try {
            Pattern pattern;
            Matcher matcher;
            final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email);
            return matcher.matches();
        } catch(Exception ex){
            return false;
        }
    }

    /**
     * isPhoneNumberValid: Validate phone number using Java reg ex. This method
     * checks if the input string is a valid phone number.
     *
     * @param
     * @return boolean: true if phone number is valid, false otherwise.
     */
    public static boolean isValidTelephone(String phoneNumber) {
        boolean isValid = false;
        /* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn
         ^\\(? : May start with an option "(" .
         (\\d{3}): Followed by 3 digits.
         \\)? : May have an optional ")"
         [- ]? : May have an optional "-" after the first 3 digits or after optional ) character.
         (\\d{3}) : Followed by 3 digits.
         [- ]? : May have another optional "-" after numeric digits.
         (\\d{4})$ : ends with four digits.

         Examples:
         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890

         */
        //Initialize reg ex for phone number.
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static Color getColor(String hex) {
        hex = hex.trim();
        hex = hex.toLowerCase();
        hex = hex.replace("#", "");
        int intValue = Integer.parseInt(hex, 16);
        Color aColor = new Color(intValue);
        return aColor;
    }

    public static String hashString(String s) {

        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(s.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; ++i) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                sb.append(0);
                sb.append(hex.charAt(hex.length() - 1));
            } else {
                sb.append(hex.substring(hex.length() - 2));
            }
        }
        return sb.toString();
    }

    public static String randomPassword(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AAB.charAt(rnd.nextInt(AAB.length())));
        }
        return sb.toString();
    }
    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public static String getParameterByName(String name) {
        HttpServletRequest req = getRequest();
        return req.getParameter(name);
    }

    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(NAB.charAt(rnd.nextInt(NAB.length())));
        }
        return sb.toString();
    }

    public static String randomNumber() {
        return randomNumber(6);
    }

    public static String randomPassword() {
        return randomString(6);
    }

    public static boolean credentialCheck(String username, String password) {
        //TODO ADD MORE BASIC PASSWORD COMPLIANCE CHECKS AND USERNAME COMPLIANCE CHECKS
        // Eg. Contains at least one upper case number, one lower case character a number
        // and a special character no spaces and is of a certain size.
        // check username is a valid email.
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isComputerCode(String input) {
        // list of common computer code file extensions
        String[] extensions = { ".java", ".py", ".cpp", ".js", ".php", ".html", ".css", ".rb" };

        // list of syntax used in various programming languages
        String[] syntax = {
                "BASIC",
                "REM",
                "public static void", // Java
                "def ", // Python
                "#include", // C++
                "class ", // Java
                "int main(", // C++
                "function(", // JavaScript
                "console.log(", // JavaScript
                "print(", // Python
                "SELECT", // MySQL
                "function main(", // Lua
                "using System;", // C#
                "<html>", // HTML
                "<style>", // CSS
                "var ", // JavaScript
                "def main():", // Python
                "require(", // JavaScript
                "public class ", // Java
                "mysqli_connect(", // PHP
                "struct", // C
                "cout << ", // C++
                "System.out.println(", // Java
                "document.getElement", // JavaScript
        };

        // check if the input string ends with any of the common file extensions
        //for (String ext : extensions) {
        //    if (input.trim().endsWith(ext)) {
        //        return true;
        //    }
        //}

        // check if the input string contains specific code syntax
        for (String s : syntax) {
            if (input.contains(s)) {
                return true;
            }
        }

        // if no matches found, return false
        return false;
    }

    public static String cleanPrompt(String prompt) {
        // remove leading and trailing whitespace
        prompt = prompt.trim();

        // replace multiple spaces with a single space
        prompt = prompt.replaceAll("\\s+", " ");

        // replace non-alphanumeric characters with a space
        prompt = prompt.replaceAll("[^a-zA-Z0-9]+", " ");

        // convert to lowercase
        prompt = prompt.toLowerCase();

        return prompt;
    }


    public static String getEmail() {
        try {
            String u = Globals.defaultUser;
            boolean f = false;
            if (f) {
                return u;
            }
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            HttpSession session = (HttpSession) externalContext.getSession(false);

            if (session != null) {
                // Retrieve the session variable
                String sessionVariable = (String) session.getAttribute("userid");

                System.out.println("user id for email:" + sessionVariable);
                return sessionVariable;
                // Process the session variable as needed
                // ...
            }
        } catch(Exception ex){

        }
        return null;
    }




    public static String getRole() {
        //String e = Globals.hm.get("userid");
        //if( r != null && !r.isEmpty() && !r.equalsIgnoreCase("unknown") ){
        //    return r;
        //}
        String u = Globals.defaultUser;
        boolean f = false;
        if( f ){
            return u;
        }
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            HttpSession session = (HttpSession) externalContext.getSession(false);

            if (session != null) {
                // Retrieve the session variable
                String sessionVariable = (String) session.getAttribute("userid");

                System.out.println("user id for email:" + sessionVariable);
                String str = Utility.getRole(sessionVariable);
                return str;
                // Process the session variable as needed
                // ...
            } else {
                System.out.println("Session is null");
            }
            return null;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static int stripCode(String orgCode) {
        if( !orgCode.toUpperCase().startsWith("ORG-")){
            return -1;
        } else {
            String splits[] = orgCode.split("-");
            int oc = -1;
            try {
                oc = Integer.valueOf(1);
            } catch(Exception ex) { oc = -1;}
            return oc;
        }
    }

    public static Integer getOrgId() {

        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            HttpSession session = (HttpSession) externalContext.getSession(false);

            if (session != null) {
                // Retrieve the session variable
                Integer sessionVariable = (Integer) session.getAttribute("orgId");

                System.out.println("org id for email:" + sessionVariable);
                return sessionVariable;
                // Process the session variable as needed
                // ...
            } else {
                System.out.println("Session is null");
            }
            return -1;
        } catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }

    }
}
