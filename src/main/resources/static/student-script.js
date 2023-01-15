var table;
const addModal = new bootstrap.Modal("#addModal", {});
const deleteModal = new bootstrap.Modal("#deleteModal", {});
const editModal = new bootstrap.Modal("#editModal", {});
const toast = new bootstrap.Toast("#toast", {});

$("#addBtn").click(() => {
  addModal.show();
});

$("#addForm").submit((e) => {
  e.preventDefault();
  addRequest();
  $("#addForm")[0].reset();
});

$("#deleteSubmit").click(() => {
  deleteRequest();
});

$("#editSubmit").click((e) => {
  e.preventDefault();
  editRequest();
  $("#editForm")[0].reset();
});

$(document).ready(function () {
  table = $("#table").DataTable({
    responsive: "true",
    ajax: {
      url: "http://localhost:1337/students",
      dataSrc: "",
    },
    columns: [
      { data: "id" },
      { data: "firstName" },
      { data: "middleName" },
      { data: "lastName" },
      { data: "age" },
      { data: "yearLevel" },
      { data: "section" },
      {
        mRender: function (data, type, row) {
          return (
            '<button type="button" class="btn btn-danger delete me-2" data-id="' +
            row.id +
            '">Delete</button>' +
            '<button type="button" class="btn btn-primary edit" data-id="' +
            row.id +
            '">Edit</button>'
          );
        },
      },
    ],
  });

  $("#table").on("click", "tbody .delete", function () {
    const student = table.row($(this).closest("tr")).data();
    $("#deleteModalTitle").text("Delete Student ID " + student.id);
    $("#deleteModal").attr("data-id", student.id);

    deleteModal.show();
  });

  $("#table").on("click", "tbody .edit", function () {
    const student = table.row($(this).closest("tr")).data();
    console.log(student);

    $("#editModalTitle").text("Edit Student ID " + student.id);
    $("#editModal").attr("data-id", student.id);

    $('#editModal input[name="firstName"]').attr("value", student.firstName);
    $('#editModal input[name="middleName"]').attr("value", student.middleName);
    $('#editModal input[name="lastName"]').attr("value", student.lastName);
    $('#editModal input[name="age"]').attr("value", student.age);
    $('#editModal input[name="yearLevel"]').attr("value", student.yearLevel);
    $('#editModal input[name="section"]').attr("value", student.section);

    editModal.show();
  });
});

function addRequest() {
  const formData = {};
  $("#addForm")
    .find("input")
    .each(function (index, node) {
      formData[node.name] = node.value;
    });
  $.ajax({
    beforeSend: function (xhrObj) {
      xhrObj.setRequestHeader("Content-Type", "application/json");
      xhrObj.setRequestHeader("Accept", "application/json");
    },
    url: "http://localhost:1337/students",
    type: "POST",
    dataType: "json",
    crossDomain: true,
    data: JSON.stringify(formData),
    success: () => {
      table.ajax.reload(null, false);
      addModal.hide();
      $("#toast-message").html("You have successfully added a Student.");
      toast.show();
    },
    error: () => {
      table.ajax.reload(null, false);
      addModal.hide();
      $("#toast-message").html(
        "There was an error in handling your add request. Please try again."
      );
      toast.show();
    },
  });
}

function deleteRequest() {
  $.ajax({
    url: "http://localhost:1337/students/" + $("#deleteModal").attr("data-id"),
    type: "DELETE",
    success: () => {
      table.ajax.reload(null, false);
      deleteModal.hide();
      $("#toast-message").html("You have successfully deleted a student.");
      toast.show();
    },
    error: () => {
      table.ajax.reload(null, false);
      deleteModal.hide();
      $("#toast-message").html(
        "There was an error in handling your delete request. Please try again."
      );
      toast.show();
    },
  });
}

function editRequest() {
  const formData = {};
  $("#editForm")
    .find("input")
    .each(function (index, node) {
      formData[node.name] = node.value;
    });
  $.ajax({
    beforeSend: function (xhrObj) {
      xhrObj.setRequestHeader("Content-Type", "application/json");
      xhrObj.setRequestHeader("Accept", "application/json");
    },
    url: "http://localhost:1337/students/" + $("#editModal").attr("data-id"),
    type: "PUT",
    dataType: "json",
    crossDomain: true,
    data: JSON.stringify(formData),
    success: () => {
      table.ajax.reload(null, false);
      editModal.hide();
      $("#toast-message").html("You have successfully edited a Student.");
      toast.show();
    },
    error: () => {
      table.ajax.reload(null, false);
      editModal.hide();
      $("#toast-message").html(
        "There was an error in handling your delete request. Please try again."
      );
      toast.show();
    },
  });
}
