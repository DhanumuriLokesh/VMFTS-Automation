Feature: Fund Module functionality
	
 @positive
  Scenario: State maker creates fund and checker approves it
    When State Maker Login "7358190473" and "123456"
    And Create a Fund and send to checker
    And State checker Login "7005357345" and "123456"
    And Approve the fund id

  @negative
  Scenario: State maker creates fund and checker rejects it
    When State Maker Login "7358190473" and "123456"
    And Create a Fund and send to checker
    And State checker Login "7005357345" and "123456"
    And Reject the fund id