package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s224830206";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Hirusha Rukmal";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testLoginSuccess_WithValidUsernamePasswordDob() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan pass", "2000-01-15"));
    }

    @Test
    public void testLoginFail_WrongUsername() {
        Assert.assertFalse(LoginService.login("wronguser", "ahsan pass", "2000-01-15"));
    }

    @Test
    public void testLoginFail_WrongPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "wrongpass", "2000-01-15"));
    }

    @Test
    public void testLoginFail_WrongDob() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan pass", "2001-01-15"));
    }

    @Test
    public void testLoginFail_EmptyUsername() {
        Assert.assertFalse(LoginService.login("", "ahsan pass", "2000-01-15"));
    }

    @Test
    public void testLoginFail_EmptyPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "", "2000-01-15"));
    }

    @Test
    public void testLoginFail_EmptyDob() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan pass", ""));
    }

    @Test
    public void testLoginFail_NullUsername() {
        Assert.assertFalse(LoginService.login(null, "ahsan pass", "2000-01-15"));
    }

    @Test
    public void testLoginFail_NullPassword() {
        Assert.assertFalse(LoginService.login("ahsan", null, "2000-01-15"));
    }

    @Test
    public void testLoginFail_NullDob() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan pass", null));
    }

    @Test
    public void testLoginFail_InvalidDobFormat() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan pass", "15-01-2000"));
    }

    @Test
    public void testLoginFail_InvalidDobValue() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan pass", "2000-13-40"));
    }

    @Test
    public void testDobFormatHelper_ValidDob() {
        Assert.assertTrue(LoginService.isValidDobFormat("2000-01-15"));
    }

    @Test
    public void testDobFormatHelper_InvalidDob() {
        Assert.assertFalse(LoginService.isValidDobFormat("15/01/2000"));
    }
}