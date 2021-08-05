@SmokeTestAllFooterOptins
Feature: Footer

  Details: user should be able to scroll all the way to the bottom of the page and click on every link.
  Proper page should pe open

  @CompanyLinks
  Scenario: User goes to main page and scrolls all the way to the bottom, and clicks on company links
    Given user is on main page
    Then user scrolls all the way to the bottom
    When user clicks on the company links the corespoding page should open as per requirement docs


  @CompanyLink
  Scenario Outline: Scenario Outline User goes to main page and scrolls all the way to the bottom, and clicks on company links
    Given user is on main page
    Then user scrolls all the way to the bottom
    When user clicks on the company Visible Text <VisibleText> the corresponding <webLink> page should open as per requirement docs
    Examples:
      | VisibleText          | webLink                                                                                                                                                                                                                                  |
      | "About"              | "https://www.expediagroup.com/home/default.aspx"                                                                                                                                                                                         |
      | "Jobs"               | "https://lifeatexpediagroup.com/"                                                                                                                                                                                                        |
      | "List your property" | https://apps.expediapartnercentral.com/en_US/list?utm_medium=referral&utm_source=wwwexpediacom-en_US&utm_campaign=Brand.DTI&utm_contentewd=footer-btn&siteId=1&tpid=1&eapid=0&langId=1033&utm_term=Brand.DTI&lasttouchMktgcode=Brand.DTI |
      | "Partnerships"       | "https://www.expediagroup.com/partner-with-us/default.aspx"                                                                                                                                                                              |
      | "Newsroom"           | "https://newsroom.expedia.com/"                                                                                                                                                                                                          |
      | "Investor Relations" | "https://www.expediagroup.com/investors/investors-overview/default.aspx"                                                                                                                                                                 |
      | "Advertising"        | "https://www.expediagroup.com/investors/investors-overview/default.aspx"
