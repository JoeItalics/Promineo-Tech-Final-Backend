/**
 * 
 */
package com.promineotech.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.application.entity.Assignment;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Joeit
 *
 */
@Validated
@RequestMapping("/assignments")
public interface AssignmentController {
  //formatter:off
  @Operation(
      summary = "Return a list of assignments with given params.",
      description = "Returns a list of assignments when a specific classId and student name are specified.",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = " List of assignments are returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Assignment.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Assignments were found with the specified params.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = true,
              description = "The students first name. Ex (' Joseph')"
              ),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = true,
              description = "The students last name. Ex (' Italico ')"
              ),
          @Parameter(
              name = "classId",
              allowEmptyValue = false,
              required = true,
              description = "The classId the assignment is from. Ex (' MATH210 ')"
              ),
      }
      
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Assignment> fetchAssignments(
      @RequestParam(required = true)
      String firstName, 
      @RequestParam(required = true)
      String lastName, 
      @RequestParam(required = true)
      String classId);

  @Operation(
      summary = "Create a new assignment for a student inside a specific class.",
      description = "Returns an Assignment object.",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = " Assignment was created.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Assignment.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "assignmentName",
              allowEmptyValue = false,
              required = true,
              description = "The assignment Name Ex ('Week 14 Algebra practice')"
              ),
          @Parameter(
              name = "classId",
              allowEmptyValue = false,
              required = true,
              description = "The classId for the assignment. Ex (' MATH210 ')"
              ),
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = true,
              description = "The students first name. Ex (' Joseph')"
              ),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = true,
              description = "The students last name. Ex (' Italico ')"
              ),
          @Parameter(
              name = "assignmentGrade",
              allowEmptyValue = false,
              required = true,
              description = "The students score for the assignment Ex (' 75 ')"
              ),
      }
      
      )
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Assignment> createAssignment(
      @RequestParam(required = true)
      String assignmentName, 
      @RequestParam(required = true)
      String classId,
      @RequestParam(required = true)
      String firstName,
      @RequestParam(required = true)
      String lastName,
      @RequestParam(required = true)
      Integer assignmentGrade);


  

}
