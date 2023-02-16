var Dialog = function (a, b) {
    this.isInit = false;
    this.is_open = false;
    this.css = typeof (a) != "undefined" ? a : "";
    this.isModal = typeof (b) != "undefined" ? b : false;
    this.name = "WDialog" + Math.round(Math.random() * 100000)
};

Dialog.prototype.init = function () {
    if (this.isInit) {
        return true
    }
    var a = '<div id="' + this.name + '" class="modal fade modal-wide ' + this.css + '" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"></div></div></div>';
    $("body").append(a);
    var b = this;
    $("#" + this.name).on("hidden.bs.modal", function (c) {
        b.is_open = false
    });
    this.isInit = true
};

Dialog.prototype.setOpenCallback = function (a) {
    if (typeof (a) !== "function") { return false }
    $("#" + this.name).on("shown.bs.modal", function (b) { a() })
};

Dialog.prototype.setCloseCallback = function (a) {
    if (typeof (a) !== "function") {
        return false
    }
    $("#" + this.name).on("hidden.bs.modal", function (b) { a() })
};

Dialog.prototype.close = function () {
    $("#" + this.name).modal("hide")
};
Dialog.prototype.isOpen = function () {
    return this.is_open
};
Dialog.prototype.open = function (c, b) {
    this.init(); this.is_open = true;
    var a = this;
    $.ajax({ dataType: "html", url: c }).done(function (d) {
        if (d != "") {
            a.changeContent(d, b)
        }
    }); return true
};
Dialog.prototype.changeContent = function (b, a) {
    this.init();
    this.is_open = true; if (this.isModal) {
        $("#" + this.name).modal({ backdrop: "static" })
    }
    $("#" + this.name).modal("show");
    $("#" + this.name + " .modal-content").html(b);
    if (typeof (a) === "function") { a(b) }
};






$(function () {
    if (typeof displayLegalMentions !== "undefined" && displayLegalMentions === "1") {
        $(".orderButton").click(function (e) {
            displayLegalMentionsDialog(function () {
                $("#payment-options-modal").modal()
            });
            return false
        })
    }
    if ($("#payment-options-modal").length) {
        var countdownTimer = null;
        var seconds = 180;
        $("#payment-options-modal").on("show.bs.modal", function (event) {
            countdownTimer = setInterval(secondPassed, 1e3);
            function secondPassed() {
                var minutes = Math.round((seconds - 30) / 60);
                var remainingSeconds = seconds % 60;
                if (remainingSeconds < 10) {
                    remainingSeconds = "0" + remainingSeconds
                } $
                    ("#countdown").html(minutes + ":" + remainingSeconds);
                if (seconds < 10) {
                    if (seconds == 0) { clearInterval(countdownTimer) }
                    $("#countdown").html("Last chance!")
                }
                else {
                    seconds--
                }
            }
        });
        $("#payment-options-modal").on("hide.bs.modal", function (event) {
            seconds = 180;
            var minutes = Math.round((seconds - 30) / 60);
            var remainingSeconds = seconds % 60;
            if (remainingSeconds < 10) {
                remainingSeconds = "0" + remainingSeconds
            } $("#countdown").html(minutes + ":" + remainingSeconds);
            clearInterval(countdownTimer)
        });
        $(".btn-default").click(function () {
            $(".modal-propose-payment-type").hide();
            $("#payment-modal-loading").show()
        })
    }
    if ($("#subscriptionForm").length) {
        $(document).on("submit", "#subscriptionForm", function (e) {
            e.stopPropagation(); var btnsubmit = $("#index-submit-btn");
            btnsubmit.attr("disabled", "disabled");
            if (!checkFormContact()) {
                btnsubmit.removeAttr("disabled");
                return e.preventDefault()
            }
            else {
                e.preventDefault();
                if (typeof displayLegalMentions !== "undefined" && displayLegalMentions === "1") {
                    displayLegalMentionsDialog(subscriptionFormSubmit)
                }
                else if (typeof grecaptcha !== "undefined") {
                    grecaptcha.execute();
                    setTimeout(function () {
                        btnsubmit.removeAttr("disabled")
                    }, 3500)
                }
                else subscriptionFormSubmit(true)
            }
        }
        )
    }
    if ($(".orderButton").length) {
        $("form.order").submit(function () {
            $(".orderButton").attr("disabled", "disabled")
        })
    }
    var current = {};
    $(".selectImg").on("click", function (e) {
        var $input = $(this).children("input");
        var selId = $(this).data("id");
        var cur = current.hasOwnProperty(selId) ? current[selId] : false;
        if (cur) {
            cur.removeClass("selected")
        }
        current[selId] = $(this);
        $input.prop("checked", true);
        $(this).addClass("selected")
    });
    $(".selectImg input[checked]").each(function () {
        $(this).closest(".selectImg").trigger("click")
    })
});
function checkFormContact() {
    var error = 0; error += checkField($("#subscriptionform-interest"));
    var errorBirthdate = 0; errorBirthdate += checkField($("#subscriptionform-dayofbirth"));
    errorBirthdate += checkField($("#subscriptionform-monthofbirth"));
    errorBirthdate += checkField($("#subscriptionform-yearofbirth"));
    if (errorBirthdate > 0) {
        $("#birthdate-wrapper-help").show()
    }
    else {
        $("#birthdate-wrapper-help").hide()
    } error += errorBirthdate;
    error += checkField($("#subscriptionform-gender"));
    error += checkField($("#subscriptionform-country"));
    error += checkField($("#subscriptionform-firstname"));
    error += checkField($("#subscriptionform-lastname"));
    error += checkField($("#subscriptionform-email"));
    error += checkField($("#subscriptionform-confirmemail"));
    if ($("#subscriptionform-email").val() == "" || $("#subscriptionform-email").val() !== $("#subscriptionform-confirmemail").val()) {
        $("#subscriptionform-email").addClass("error");
        $("#subscriptionform-confirmemail").addClass("error");
        error += 1
    } else {
        $("#subscriptionform-email").removeClass("error");
        $("#subscriptionform-confirmemail").removeClass("error")
    }
    return error > 0 ? false : true
} function checkField($field) {
    var $help = $field.parent().next();
    if ($field.val() === "") {
        if ($help.hasClass("help")) {
            $help.show()
        } $field.addClass("error");
        return 1
    } else {
        if ($help.hasClass("help")) {
            $help.hide()
        } $field.removeClass("error");
        return 0
    }
}
function checkemail(value) {
    var valid = true, regexp = /^((?:"?([^"]*)"?\s)?)(?:\s+)?(?:(<?)((.+)@([^>]+))(>?))$/, matches = regexp.exec(value);
    if (matches === null) {
        valid = false
    } else {
        valid = true
    } return valid
} function fillDropdownWithRange(jObject, rangeEnd) {
    var options = [];
    var selected = jObject.find(":selected").val();
    var secondValue = jObject.find("option:eq(2)").val();
    var firstValue = jObject.find("option:first").val();
    var isZeroStartedList = secondValue.charAt(0) === "0";
    var numbers = Array.apply(null, Array(rangeEnd)).map(function (_, i) { return i + 1 });
    for (var i = 0; i < numbers.length; i++) {
        var numberValue = numbers[i];
        var optionValue = isZeroStartedList ? parseInt(numberValue) < 10 ? numberValue = "0" + numberValue : numberValue : numberValue;
        options.push({
            value: optionValue, text: optionValue
        })
    }
    jObject.find("option" + (firstValue !== "" ? "" : ":not(:first)")).remove().end();
    $.each(options, function (i, item) {
        jObject.append($("<option>", {
            value: item.value, text: item.text
        }))
    });
    if ($.inArray(parseInt(selected), numbers) === -1) {
        jObject.prop("selectedIndex", 0)
    }
    else {
        jObject.val(selected)
    }
} function calculateDaysInMonth(year, month) {
    var count = new Date(year, month, 0).getDate(); return isNaN(count) ? 31 : count
} if (typeof displayLegalMentions !== "undefined" && displayLegalMentions === "1") {
    var legalMentionsDialog = new Dialog("acceptLegalMentions", true);
    var legalMentionsDialogContent = '<div class="modal-header" style="border-bottom: 0px">' + ' <h4 class="modal-title" id="myModalLabel">' + messages.get("common.confirm.reading.title") + "</h4>" + "</div>" + '<div class="form-group" id="acceptGeneralTermsMandatory">' + '<div class="row" >' + '<div class="col-sm-10 col-xs-8 col-xs-offset-1 col-sm-offset-1" style="width: revert; color: red; font-weight: bolder">' + messages.get("common.confirm.reading.accept.mandatory") + "</div>" + "</div>" + "</div>" + '<div class="form-group" id="acceptGeneralTermsCheckBox">' + '<div class="row" >' + '<div class="col-xs-1 col-xs-offset-1" style="width: revert">' + '<input type="checkbox" id="acceptGeneralTerms" name="acceptGeneralTerms" >' + "</div>" + '<div class="col-sm-10 col-xs-8" style="padding-left: 0px; ; font-size: 15px">' + '<label for="acceptGeneralTerms">' + messages.get("common.confirm.reading.general") + '<a href="/conditions-generales" target="_blank">' + messages.get("common.confirm.reading.tos") + "</a>" + '<span  data-toggle="tooltip">' + " (?)" + "</span>" + "</label>" + "</div>" + "</div>" + "</div>" + '<div class="modal-footer" style="text-align: center; border-top: 0px">' + '<button type="button" class="btn btn-success btnAcceptLegalMentions">' + messages.get("common.confirm.reading.continue") + "</button>" + "</div>"
} function displayLegalMentionsDialog(callback) {
    legalMentionsDialog.changeContent(legalMentionsDialogContent, function () {
        $("#acceptGeneralTermsMandatory").hide();
        $('[data-toggle="tooltip"]').tooltip({
            title: '<div class="tooltiptext">' + messages.get("common.confirm.reading.tooltip") + "</div>", html: true, placement: "bottom"
        });
        $(".modal-propose-payment-type").hide();
        $(".btnAcceptLegalMentions").on("click", function (e) {
            if ($('input[name="acceptGeneralTerms"]:checked').val()) {
                legalMentionsDialog.close();
                $(".modal-propose-payment-type").show();
                if (typeof grecaptcha !== "undefined") {
                    grecaptcha.execute()
                } else {
                    callback(true)
                }
            } else {
                $("#acceptGeneralTermsMandatory").show()
            }
        })
    })
}
function subscriptionFormSubmit() {
    $.ajax({
        dataType: "json", url: "/tchat-simule/subscribe", type: "POST", data: $("#subscriptionForm").serialize() + "&landing=" + $("#landing").val(), success: function (res) {
            if (res.error) {
                var Dial = new Dialog("verifyEmail", true);

                Dial.changeContent('<div class="modal-header"><h4 class="modal-title" id="myModalLabel">'
                 + messages.get("cdo.views.tchat.simule.index.verify.email") 
                 + '</h4></div><div class="modal-body" style="text-align :center;">'
                 + res.data + '</div><div class="modal-footer"><button type="button" class="btn btn-success btnVerifyEmail">'
                 + messages.get("cdo.views.tchat.simule.index.validate") 
                 + "</button></div>", function () {
                    $(".btnVerifyEmail").on("click", function (e) {
                        if ($(".inputVerifyEmail").length > 0) {
                            var newEmail = $("input[name=newEmail]:checked").val();
                            if (newEmail != "") {
                                $("#subscriptionform-email").val(newEmail);
                                $("#subscriptionform-confirmemail").val(newEmail);
                                Dial.close(); $("#index-submit-btn").removeAttr("disabled")
                            }
                        } else {
                            Dial.close();
                            $("#index-submit-btn").removeAttr("disabled")
                        }
                    })
                }
                );
                if (typeof grecaptcha !== "undefined") grecaptcha.reset()
            } else {
                if (typeof makeGDPRCompliant !== "undefined" && makeGDPRCompliant === "1") {
                    Cookies.set("trackingAccepted", "ok", {
                        expires: 180
                    })
                }
                window.location.href = res.data.url
            }
        }
    })
} 